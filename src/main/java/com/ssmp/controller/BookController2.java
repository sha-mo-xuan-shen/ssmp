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

    @GetMapping("/{id}")
    public R getById(@PathVariable int id){
        Book byId = iBookService.getById(id);
        R r = new R();
        r.setFlag(byId!=null);
        r.setData(byId);
        return r;
    }
    @PostMapping
    public R save(@RequestBody Book book){
        R r = new R();
        boolean flag = iBookService.save(book);
        r.setFlag(flag);
        r.setMsg(flag?"添加成功":"添加失败");
        return r;
    }

    @PutMapping
    public R alert(@RequestBody Book book){
        R r = new R();
        r.setFlag(iBookService.updateById(book));
        return r;
    }

    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id){
        R r = new R();
        r.setFlag(iBookService.removeById(id));
        System.out.println(r);
        return r;
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        // System.out.println("实例========>"+book);
        IPage<Book> page = iBookService.getPage(currentPage, pageSize,book);
        if(currentPage>page.getPages()){
            page = iBookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new R(page!=null,page);
    }
}
