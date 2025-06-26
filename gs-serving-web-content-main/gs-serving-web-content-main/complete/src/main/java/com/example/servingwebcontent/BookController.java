package com.example.servingwebcontent;

import com.example.servingwebcontent.database.BookAiven;
import com.example.servingwebcontent.database.InsertBookAiven;
import com.example.servingwebcontent.database.BorrowBookAiven;
import com.example.servingwebcontent.database.ReturnBookAiven;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private final BookAiven bookAiven;

    public BookController(BookAiven bookAiven) {
        this.bookAiven = bookAiven;
    }

    // 📚 Hiển thị danh sách sách
    @GetMapping("/book")
    public String getBooks(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Book> books = (keyword != null && !keyword.isEmpty())
                ? bookAiven.searchBooks(keyword)
                : bookAiven.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    // ➕ Hiển thị form thêm sách
    @GetMapping("/book/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    // ✅ Xử lý thêm sách
    @PostMapping("/book/add")
    public String addBook(@ModelAttribute("book") Book book) {
        InsertBookAiven iba = new InsertBookAiven();
        iba.insertBook(book);
        return "redirect:/book";
    }

    // ✏️ Hiển thị form chỉnh sửa
    @GetMapping("/book/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Book book = bookAiven.findBookById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    // 💾 Xử lý cập nhật sách
    @PostMapping("/book/edit")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookAiven.updateBook(book);
        return "redirect:/book";
    }

    // 🗑️ Xóa sách
    @PostMapping("/book/delete")
    public String deleteBook(@RequestParam String id) {
        bookAiven.deleteBook(id);
        return "redirect:/book";
    }

    // 📖 Mượn sách
    @PostMapping("/borrowbook")
    public String borrowBook(@RequestParam String bookId) {
        BorrowBookAiven bba = new BorrowBookAiven();
        bba.borrowBook(bookId);
        return "redirect:/book";
    }

    // 🔁 Trả sách
    @PostMapping("/returnBook")
    public String returnBook(@RequestParam String bookId) {
        ReturnBookAiven rba = new ReturnBookAiven();
        rba.returnBook(bookId);
        return "redirect:/book";
    }

    // 📄 Danh sách sách đã mượn
    @GetMapping("/borrowedbooks")
    public String getBorrowedBooks(Model model) {
        model.addAttribute("books", bookAiven.getBorrowedBooks());
        return "book/borrowedbooks";
    }
}
