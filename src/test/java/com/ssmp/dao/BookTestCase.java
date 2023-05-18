package com.ssmp.dao;

import com.ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTestCase {
    @Autowired
    BookDao bookDao;
    @Test
    public void get(){
        Book byId = bookDao.getById(1);
        System.out.println(byId);
    }
}
