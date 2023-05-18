package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceCase {
    @Autowired
    IBookService iBookService;

    @Test
    public void getPage(){
        IPage page = new Page(1,5);
        iBookService.page(page,null);
    }
}
