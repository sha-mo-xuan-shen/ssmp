package com.ssmp.service;

import com.ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceCase {
    @Autowired
    BookService bookService;

    @Test
    public void save(){
        Book book = new Book();
        book.setName("眼");
        book.setType("丁真");
        book.setDescription("鉴定为假");
        bookService.save(book);
    }
    @Test
    public void getPage(){
        bookService.getByPage(1,3);
    }
}
