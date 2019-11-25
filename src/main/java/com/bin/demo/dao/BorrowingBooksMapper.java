package com.bin.demo.dao;


import com.bin.demo.model.BorrowingBooks;

import java.util.List;

public interface BorrowingBooksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BorrowingBooks record);

    int insertSelective(BorrowingBooks record);

    BorrowingBooks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BorrowingBooks record);

    int updateByPrimaryKey(BorrowingBooks record);

    List<BorrowingBooks> selectBorrowingList();

    List<BorrowingBooks> selectBorrowingListByUserId(Integer userId);
}