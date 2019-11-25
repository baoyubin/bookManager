package com.bin.demo.service.impl;


import com.bin.demo.dao.BookMapper;
import com.bin.demo.dao.BorrowingBooksMapper;
import com.bin.demo.dao.UserMapper;
import com.bin.demo.model.Book;
import com.bin.demo.model.BorrowingBooks;
import com.bin.demo.model.User;
import com.bin.demo.model.VO.BorrowingBooksVo;
import com.bin.demo.model.VO.CreateVo;
import com.bin.demo.service.IUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    BorrowingBooksMapper borrowingBooksMapper;
    @Autowired
    BookMapper bookMapper;

    @Override
    public User findByUserSno(Integer userSno) {
        User res = userMapper.selectByUserSno(userSno);
        return res;
    }

    @Override
    public User userLogin(User user, String password) {
        if(user.getUserPwd().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public Boolean updateUser(User user) {
        int n=userMapper.updateByPrimaryKey(user);
        if(n>0){
            //修改成功，更新session对象
            return true;
        }
        return  false;
    }

    @Override
    public PageInfo<BorrowingBooksVo> findBorrowingBooks(int pageNum,User session_user) {
        Page page = PageHelper.startPage(pageNum, 5);
        List<BorrowingBooks> list = borrowingBooksMapper.selectBorrowingListByUserId(session_user.getUserId());
        CreateVo createVo = new CreateVo();
        return  createVo.getBorrowingBooksVoPageInfo(list, bookMapper, userMapper);
    }

    @Override
    @Transactional
    public Boolean returnBook(int id,User session_user) {
        BorrowingBooks borrowingBooks = borrowingBooksMapper.selectByPrimaryKey(id);
        if (session_user.getUserId() == borrowingBooks.getUserId()  &&  borrowingBooks.getReturnData() == null){
            Date d = new Date();
            java.sql.Date date = new java.sql.Date(d.getTime()); // 转化成字段的数据类型
            borrowingBooks.setReturnData(date);
            //更新
            borrowingBooksMapper.updateByPrimaryKey(borrowingBooks);
            Book book = bookMapper.selectByPrimaryKey(borrowingBooks.getBookId());
            book.setBookNum(book.getBookNum()+1);
            bookMapper.updateByPrimaryKey(book);
            return true ;
        }
        return false;
    }

    @Override
    @Transactional //事务
    public Boolean borrowBook(int bookId, User session_user) {
        Book book = bookMapper.selectByPrimaryKey(bookId);
        if (0 != book.getBookNum()){
            book.setBookNum(book.getBookNum()-1);
            bookMapper.updateByPrimaryKey(book);
            BorrowingBooks borrowingBooks = new BorrowingBooks();
            borrowingBooks.setUserId(session_user.getUserId());
            borrowingBooks.setBookId(bookId);
            Date d = new Date();
            java.sql.Date date = new java.sql.Date(d.getTime());
            borrowingBooks.setBorrowDate(date);
            borrowingBooks.setReturnData(null);
            borrowingBooksMapper.insertSelective(borrowingBooks);
            //减
            return true;
        }
        return  false;
    }
}
