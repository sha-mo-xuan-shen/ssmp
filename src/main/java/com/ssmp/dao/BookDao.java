package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {

    @Select("select * from tbl_book where id=#{id}")//别忘了#
    Book getById(Integer id);
    @Select("select * from tbl_book where name=#{name}")
    public Book getByName(String name);
    @Select("select * from tbl_book where type=#{type}")
    public Book getByType(String type);
    @Select("select * from tbl_book where description=#{description}")
    public Book getByDescription(String description);
}
