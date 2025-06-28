package com.example.servingwebcontent;

import com.example.servingwebcontent.controller.BookController;
import com.example.servingwebcontent.database.BookAiven;
import com.example.servingwebcontent.model.Book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({GreetingController.class, BookController.class}) // ✅ Bao gồm cả hai controller
public class ServingWebContentApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookAiven bookAiven; // Dùng cho BookController test

    // ==== Greeting Controller tests ====
    @Test
    public void homePage() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(content().string(containsString("Get your greeting")));
    }

    @Test
    public void greeting() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(content().string(containsString("Hello, World!")));
    }

    @Test
    public void greetingWithUser() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "Greg"))
                .andExpect(content().string(containsString("Hello, Greg!")));
    }

    // ==== Book Controller test ====
    @Test
    public void testGetBorrowedBooks() throws Exception {
        Book book1 = new Book("b1", "Book One", "Author A", "Shelf A");
        book1.muonSach();

        when(bookAiven.getBorrowedBooks()).thenReturn(Arrays.asList(book1));

        mockMvc.perform(get("/borrowedbooks"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("books"))
                .andExpect(view().name("borrowedbooks"))
                .andExpect(content().string(containsString("Book One")));
    }
}
