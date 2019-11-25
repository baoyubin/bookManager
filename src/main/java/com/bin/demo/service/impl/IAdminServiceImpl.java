package com.bin.demo.service.impl;


import com.bin.demo.dao.*;
import com.bin.demo.model.*;
import com.bin.demo.model.VO.BookVo;
import com.bin.demo.model.VO.BorrowingBooksVo;
import com.bin.demo.model.VO.CreateVo;
import com.bin.demo.service.IAdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class IAdminServiceImpl implements IAdminService {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    UserMapper  userMapper;
    @Autowired
    BookCategoryMapper bookCategoryMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    BorrowingBooksMapper borrowingBooksMapper;

    /**
     * 登录
     * @param adminName
     * @param password
     * @return
     */
    @Override
    public Admin adminLogin(@Param("adminName") String adminName, @Param("password")String password) {
        for(Admin admin:adminMapper.selectAdminList()) {
            if (admin.getAdminName().equals(adminName)) {
                if (admin.getAdminPwd().equals(password)) {
                    return admin;
                }
            }
        }
        return null;
    }

    @Override
    public PageInfo<User> findUserList(int pageNum) {
        Page page = PageHelper.startPage(pageNum, 10);
        PageInfo<User> info = new PageInfo<>(userMapper.selectUserList());
        long total = page.getTotal();
        return info;
    }

    @Override
    public int deleteUserById(int userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public boolean addBookCategory(BookCategory bookCategory) {
        int n=bookCategoryMapper.insert(bookCategory);
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<BookCategory> findCategoryList(int pageNum) {
        Page page = PageHelper.startPage(pageNum, 8);
        List<BookCategory> list = bookCategoryMapper.selectCategoryList();
        PageInfo<BookCategory> categoryList =new PageInfo<>(list);
        return categoryList;
    }

    @Override
    public int deleteCategoryById(int categoryId) {
        return bookCategoryMapper.deleteByPrimaryKey(categoryId);
    }



    @Override
    public boolean addBook(Book book) {
        int n = bookMapper.insertSelective(book);
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public int deleteBookById(int bookId) {
        return bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public PageInfo<BorrowingBooksVo> findBorrowingBooksList(int pageNum) {
        Page page = PageHelper.startPage(pageNum, 5);
        List<BorrowingBooks> list = borrowingBooksMapper.selectBorrowingList();
        CreateVo createVo = new CreateVo();
        return createVo.getBorrowingBooksVoPageInfo(list, bookMapper, userMapper);
    }


}
