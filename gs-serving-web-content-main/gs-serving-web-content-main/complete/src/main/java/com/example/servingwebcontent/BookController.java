package com.example.servingwebcontent;

import com.example.servingwebcontent.database.BookAiven;
import com.example.servingwebcontent.database.InsertBookAiven;
import com.example.servingwebcontent.database.BorrowBookAiven;
import com.example.servingwebcontent.database.ReturnBookAiven;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookAiven bookAiven;

    // ✅ Inject BookAiven để test mock được
    public BookController(BookAiven bookAiven) {
        this.bookAiven = bookAiven;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookAiven.getAllBooks());
        return "booklist";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam String title, @RequestParam String author, Model model) {
        InsertBookAiven iba = new InsertBookAiven();
        Book book = new Book("b" + System.currentTimeMillis(), title, author, "N/A"); // vị trí có thể tùy chỉnh
        iba.insertBook(book);
        return "redirect:/books";
    }

    @PostMapping("/borrowBook")
    public String borrowBook(@RequestParam String bookId) {
        BorrowBookAiven bba = new BorrowBookAiven();
        bba.borrowBook(bookId);
        return "redirect:/books";
    }

    @PostMapping("/returnBook")
    public String returnBook(@RequestParam String bookId) {
        ReturnBookAiven rba = new ReturnBookAiven();
        rba.returnBook(bookId);
        return "redirect:/books";
    }

    @GetMapping("/borrowedBooks")
    public String getBorrowedBooks(Model model) {
        model.addAttribute("books", bookAiven.getBorrowedBooks());
        return "borrowedbooks";
    }
}
