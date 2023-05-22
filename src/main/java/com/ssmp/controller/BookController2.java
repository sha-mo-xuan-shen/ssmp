package com.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmp.controller.util.R;
import com.ssmp.domain.Book;
import com.ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    IBookService iBookService;

    @GetMapping
    public R getAll(){
        R r = new R();
        List<Book> list = iBookService.list();
        r.setFlag(list!=null);
        r.setData(list);
        return r;
    }

    @PostMapping
    public R save(@RequestBody Book book){
        R r = new R();
        r.setFlag(iBookService.save(book));
        return r;
    }

    @PutMapping
    public R alert(@RequestBody Book book){

        return new R(iBookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id){
        return new R(iBookService.removeById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        IPage<Book> page = iBookService.getPage(currentPage, pageSize);
        return new R(page!=null,page);
    }
}
