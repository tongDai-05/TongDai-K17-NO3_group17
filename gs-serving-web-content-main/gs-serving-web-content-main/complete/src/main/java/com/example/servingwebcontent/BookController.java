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

    @GetMapping("/books")
    public String getBooks(Model model) {
        BookAiven bookAiven = new BookAiven();
        model.addAttribute("books", bookAiven.getAllBooks());
        return "booklist";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam String title, @RequestParam String author, Model model) {
        InsertBookAiven iba = new InsertBookAiven();
        iba.insertBook(title, author);
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
}
