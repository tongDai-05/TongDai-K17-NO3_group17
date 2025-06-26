package com.example.servingwebcontent;

import com.example.servingwebcontent.database.BookAiven;
import com.example.servingwebcontent.database.InsertBookAiven;
import com.example.servingwebcontent.database.BorrowBookAiven;
import com.example.servingwebcontent.database.ReturnBookAiven;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookAiven bookAiven;

    public BookController(BookAiven bookAiven) {
        this.bookAiven = bookAiven;
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam String title, @RequestParam String author, Model model) {
        InsertBookAiven iba = new InsertBookAiven();
        Book book = new Book("b" + System.currentTimeMillis(), title, author, "N/A");
        iba.insertBook(book);
        return "redirect:/books";
    }

    @PostMapping("/borrowbook")
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

    @GetMapping("/borrowedbooks")
    public String getBorrowedBooks(Model model) {
        model.addAttribute("books", bookAiven.getBorrowedBooks());
        return "borrowedbooks";
    }

    @GetMapping("/books")
    public String getBooks(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Book> books;
        if (keyword != null && !keyword.isEmpty()) {
            books = bookAiven.searchBooks(keyword);
        } else {
            books = bookAiven.getAllBooks();
        }
        model.addAttribute("books", books);
        return "booklist";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/greeting";
    }

}
