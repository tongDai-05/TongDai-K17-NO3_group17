package com.example.servingwebcontent;

import com.example.servingwebcontent.database.BookAiven;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookAiven bookAiven;

    @Test
    public void testGetAllBooks() throws Exception {
        Book book1 = new Book("b1", "Book One", "Author A", "Shelf A");
        Book book2 = new Book("b2", "Book Two", "Author B", "Shelf B");

        when(bookAiven.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("books"))
                .andExpect(view().name("booklist"))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Book One")));
    }

    @Test
    public void testGetBorrowedBooks() throws Exception {
        Book book1 = new Book("b1", "Book One", "Author A", "Shelf A");
        book1.muonSach(); // đánh dấu đã mượn

        when(bookAiven.getBorrowedBooks()).thenReturn(Arrays.asList(book1));

        mockMvc.perform(get("/borrowedbooks"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("books"))
                .andExpect(view().name("borrowedbooks"))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Book One")));
    }
}
