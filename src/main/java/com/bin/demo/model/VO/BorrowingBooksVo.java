package com.bin.demo.model.VO;


import com.bin.demo.model.Book;
import com.bin.demo.model.User;

/**
 * @author yangxuechen
 * @date 2018/10/12
 * 添加视图层对象
 * @date 2018/11/3
 * 新增属性 user
 */
public class BorrowingBooksVo {
    private  Integer Id;
    private User user;
    private Book book;  //借阅书籍
    private String dateOfBorrowing;  //借书日期
    private String dateOfReturn;    //还书日期
    private String isReturn;  //是否归还

    public void setIsReturn(String isReturn) {
        this.isReturn = isReturn;
    }

    public String getIsReturn() {
        return isReturn;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setDateOfBorrowing(String dateOfBorrowing) {
        this.dateOfBorrowing = dateOfBorrowing;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Book getBook() {
        return book;
    }

    public String getDateOfBorrowing() {
        return dateOfBorrowing;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
