package com.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmp.domain.Book;
import com.ssmp.service.IBookService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    IBookService iBookService;

    @GetMapping
    public List<Book> getAll(){
        List<Book> list = iBookService.list();
        return list;
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return iBookService.save(book);
    }

    @PutMapping
    public Boolean alert(@RequestBody Book book){
        return iBookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable Integer id){
        return iBookService.removeById(id);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        IPage<Book> page = iBookService.getPage(currentPage, pageSize);
        return page;
    }
}
