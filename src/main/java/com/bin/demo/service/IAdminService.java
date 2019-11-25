package com.bin.demo.service;


import com.bin.demo.model.*;
import com.bin.demo.model.VO.BookVo;
import com.bin.demo.model.VO.BorrowingBooksVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface IAdminService {

    //管理员登陆
    public Admin adminLogin(String name, String password);

    //分页查询所有用户
    public PageInfo<User> findUserList(int pageNum);

    //根据用户id删除用户
    int deleteUserById(int userId);

    //添加用户
    int addUser(User user);

    //分页查询种类
    public PageInfo<BookCategory> findCategoryList(int pageNum);

    //添加书籍种类
    boolean addBookCategory(BookCategory bookCategory);

    //根据id删除种类
    int deleteCategoryById(int categoryId);

    //录入新书
    public boolean addBook(Book book);

    //根据id删除书籍
    int deleteBookById(int bookId);

    //分页查询所有用户借书记录
    public PageInfo<BorrowingBooksVo> findBorrowingBooksList(int pageNum);
}
