package com.example.servingwebcontent.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.servingwebcontent.database.BookAiven;
@Controller
public class loanRecordController {
     private final BookAiven bookData = new BookAiven();

    @GetMapping("/loanRecord")
    public String loanRecord(Model model) {
        // Lấy danh sách tất cả sách
        List<Book> allBooks = bookData.getAllBooks();

        // Lọc ra các sách đã được mượn
        List<Book> borrowedBooks = allBooks.stream()
                .filter(Book::isBorrowed)
                .collect(Collectors.toList());

        // Truyền danh sách sách đã mượn vào model để hiển thị ở loanrecord.html
        model.addAttribute("loanRecords", borrowedBooks);

        return "loanrecord"; // Tên view (loanrecord.html)
}
}