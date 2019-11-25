package com.bin.demo.service.impl;

import com.bin.demo.dao.BookMapper;
import com.bin.demo.model.Book;
import com.bin.demo.model.VO.BookVo;
import com.bin.demo.model.VO.CreateVo;
import com.bin.demo.service.IBookService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class IBookServiceImpl implements IBookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public BookVo findBooksByBookName(String bookName) {
        Book book  = bookMapper.selectByBookName(bookName);
        CreateVo createVo = new CreateVo();
        BookVo bookVoByName = createVo.createBookVo(book);
        return bookVoByName;
    }


    @Override
    public PageInfo<BookVo> findBookVoList(int pageNum) {
        Page page = PageHelper.startPage(pageNum, 8);
        List<Book> list = bookMapper.selectBookList();
        CreateVo createVo = new CreateVo();
        List<BookVo>  bookVos =  createVo.createBookVo(list);
        PageInfo<BookVo> bookVoPageInfo = new PageInfo(list);
        bookVoPageInfo.setList(bookVos);
        return bookVoPageInfo;
    }






}
