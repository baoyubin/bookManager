package com.bin.demo.service;

import com.bin.demo.model.User;
import com.bin.demo.model.VO.BorrowingBooksVo;
import com.github.pagehelper.PageInfo;

import javax.validation.Valid;
import java.util.List;


public interface IUserService {
    //根据学号查询
    User findByUserSno(Integer userSno);

    //用户登录
    User userLogin(User user,String password);

    //更改用户信息
    Boolean updateUser( User user);

    //分页查询个人借书记录
    PageInfo<BorrowingBooksVo> findBorrowingBooks(int pageNum,User session_user);

    //还书
    Boolean returnBook(int id,User session_user);

    //借书
    Boolean borrowBook(int bookId,User session_user);
}
