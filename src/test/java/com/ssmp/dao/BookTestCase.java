package com.ssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookTestCase {
    @Autowired
    BookDao bookDao;
    @Test
    public void get(){
        Book byId = bookDao.getById(1);
        Book book = bookDao.selectById(2);
        System.out.println(byId);
        System.out.println(book);
    }
    @Test
    public void insert(){
        bookDao.selectById(61);
        Book book = new Book();
        book.setName("新");
        book.setType("新");
        book.setDescription("新");
        bookDao.insert(book);
    }
    @Test
    public void update(){
        Book book = new Book();
        book.setId(61);
        book.setName("改");
        book.setType("改");
        book.setDescription("改");
        bookDao.updateById(book);
        bookDao.selectById(61);
    }
    @Test
    public void getAll(){
        List<Book> books = bookDao.selectList(null);
    }
    @Test
    public void getByPage(){
        IPage p = new Page(2,5);
        bookDao.selectPage(p,null);
    }
    @Test
    public void getBy(){
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.like("description","鲁迅");
        String name=null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name!=null,Book::getDescription,name);
        // bookDao.selectList(wrapper);
        bookDao.selectList(lqw);
    }
}
