package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.BookAiven;
import com.example.servingwebcontent.database.BorrowRecordAiven;
import com.example.servingwebcontent.model.Book;
import com.example.servingwebcontent.model.BorrowRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookAiven bookAiven;
    private final BorrowRecordAiven borrowRecordAiven;

    public BookController(BookAiven bookAiven, BorrowRecordAiven borrowRecordAiven) {
        this.bookAiven = bookAiven;
        this.borrowRecordAiven = borrowRecordAiven;
    }

    @GetMapping
    public String listBooks(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Book> books = (keyword != null && !keyword.isEmpty()) ? 
                bookAiven.searchBooks(keyword) : bookAiven.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        // Không tự sinh UUID nữa, ID do người dùng nhập từ form
        book.setBorrowed(false);  // Khi thêm mới mặc định chưa mượn
        bookAiven.insertBook(book);
        return "redirect:/book";
    }

    @GetMapping("/borrow/{bookId}")
    public String showBorrowForm(@PathVariable String bookId, Model model) {
        Book book = bookAiven.findBookById(bookId);
        if (book == null || book.isBorrowed()) {
            return "redirect:/book";
        }
        BorrowRecord record = new BorrowRecord();
        record.setBookId(bookId);
        record.setBorrowDate(LocalDate.now());
        record.setDueDate(LocalDate.now().plusDays(14));
        model.addAttribute("borrowRecord", record);
        return "book/borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(@ModelAttribute BorrowRecord borrowRecord) {
        borrowRecord.setRecordId(UUID.randomUUID().toString());
        borrowRecordAiven.insert(borrowRecord);
        bookAiven.updateBorrowedStatus(borrowRecord.getBookId(), true);
        return "redirect:/book";
    }

    @GetMapping("/edit/{bookId}")
public String showEditForm(@PathVariable String bookId, Model model) {
    Book book = bookAiven.findBookById(bookId);
    if (book == null) {
        return "redirect:/book";
    }
    model.addAttribute("book", book);
    return "book/edit"; // view: book/edit.html
}

    @PostMapping("/edit")
public String editBook(@ModelAttribute Book book) {
    bookAiven.updateBook(book);
    return "redirect:/book";
}

    @PostMapping("/return")
    public String returnBook(@RequestParam String bookId) {
        borrowRecordAiven.deleteByBookId(bookId);
        bookAiven.updateBorrowedStatus(bookId, false);
        return "redirect:/book";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam String id) {
        borrowRecordAiven.deleteByBookId(id);
        bookAiven.deleteBook(id);
        return "redirect:/book";
    }
}
