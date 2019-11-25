package com.bin.demo.service;

import com.bin.demo.model.VO.BookVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBookService {
    /**
     * 根据书名查找书籍
     * @param bookName
     * @return
     */
    public BookVo findBooksByBookName(String bookName);

    //分页查询书籍
    public PageInfo<BookVo> findBookVoList(int pageNum);


}
