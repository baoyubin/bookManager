package com.bin.demo.model.VO;

import com.bin.demo.dao.BookMapper;
import com.bin.demo.dao.UserMapper;
import com.bin.demo.model.Book;
import com.bin.demo.model.BorrowingBooks;
import com.github.pagehelper.PageInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CreateVo {
    //创建BookVoList
    public static List<BookVo> createBookVo(List<Book> list) {
        List<BookVo> bookVos=new LinkedList<>();
        for (Book book:list
        ) {
            BookVo bookVo = createBookVo(book);
            bookVos.add(bookVo);
        }
        return  bookVos;
    }
    //创建BookVo
    public static BookVo createBookVo(Book book) {
        BookVo bookVo = new BookVo();
        bookVo.setBookId(book.getBookId());
        bookVo.setBookAuthor(book.getBookAuthor());
        bookVo.setBookName(book.getBookName());
        bookVo.setBookPublish(book.getBookPublish());
        bookVo.setBookNum(book.getBookNum());
        if (0 == book.getBookNum()){
            bookVo.setIsExist("不可借");
        }
        else{
            bookVo.setIsExist("可借");
        }
        return bookVo;
    }
    //创建borrowBooksVo
    public static PageInfo<BorrowingBooksVo> getBorrowingBooksVoPageInfo(List<BorrowingBooks> list, BookMapper bookMapper, UserMapper userMapper) {
        List<BorrowingBooksVo>  borrowingBooksVos= new LinkedList<>();
        for (BorrowingBooks borrowingBooks:list
        ) {
            BorrowingBooksVo borrowingBooksVo = new BorrowingBooksVo();
            borrowingBooksVo.setId(borrowingBooks.getId());
            borrowingBooksVo.setBook(bookMapper.selectByPrimaryKey(borrowingBooks.getBookId()));
            borrowingBooksVo.setUser(userMapper.selectByPrimaryKey(borrowingBooks.getUserId()));
            //日期转换
            Date date1=borrowingBooks.getBorrowDate();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String dateOfBorrowing=sdf.format(date1);
            borrowingBooksVo.setDateOfBorrowing(dateOfBorrowing);

            //日期转换
            if (null != borrowingBooks.getReturnData()) {
                Date dateReturn = borrowingBooks.getReturnData();
                SimpleDateFormat sdfReturn = new SimpleDateFormat("yyyy-MM-dd");
                String dateOfReturn = sdfReturn.format(dateReturn);
                borrowingBooksVo.setDateOfReturn(dateOfReturn);
                borrowingBooksVo.setIsReturn("以还");
            }
            else {borrowingBooksVo.setDateOfReturn("未归还");
            borrowingBooksVo.setIsReturn("还书");
            }
            borrowingBooksVos.add(borrowingBooksVo);
        }
        PageInfo<BorrowingBooksVo> bookVoPageInfo = new PageInfo(list);
        bookVoPageInfo.setList(borrowingBooksVos);
        return bookVoPageInfo;
    }
}
