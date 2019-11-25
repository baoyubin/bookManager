package com.bin.demo.dao;

import com.bin.demo.model.Admin;
import com.bin.demo.model.BookCategory;

import java.util.List;

public interface BookCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);

    List<BookCategory> selectCategoryList();
}