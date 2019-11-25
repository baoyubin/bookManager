package com.bin.demo;

import com.bin.demo.dao.BookCategoryMapper;
import com.bin.demo.dao.BookMapper;
import com.bin.demo.dao.BorrowingBooksMapper;
import com.bin.demo.dao.UserMapper;
import com.bin.demo.model.Book;
import com.bin.demo.model.BookCategory;
import com.bin.demo.model.BorrowingBooks;
import com.bin.demo.model.VO.BookVo;
import com.bin.demo.service.IAdminService;
import com.bin.demo.service.IBookService;
import com.bin.demo.service.IUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
 @Autowired
    IAdminService iAdminService;
 @Autowired
    IUserService iUserService;
 @Autowired
 BorrowingBooksMapper borrowingBooksMapper;
 @Autowired
    BookMapper bookMapper;
 @Autowired
    UserMapper userMapper;
 @Autowired
    IBookService iBookService;
    @Test
    void contextLoads() {
//        PageInfo<BookCategory> categoryList =iAdminService.findCategoryList(1);
//        for (BookCategory i: categoryList.getList()
//             ) {
//            System.out.println(i.getCategoryName());
//        }
        if(iUserService.borrowBook(6,userMapper.selectByPrimaryKey(1))){
            System.out.println("true");
        }
        else {
            System.out.println( "false");
        }

    }

}
