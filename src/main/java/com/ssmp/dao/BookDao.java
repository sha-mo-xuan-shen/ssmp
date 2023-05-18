package com.ssmp.dao;

import com.ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {

    @Select("select * from tbl_book where id=#{id}")//别忘了#
    Book getById(Integer id);
}
