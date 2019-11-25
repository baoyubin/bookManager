package com.bin.demo.model;

import java.util.Date;

public class BorrowingBooks {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Date borrowDate;

    private Date returnData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnData() {
        return returnData;
    }

    public void setReturnData(Date returnData) {
        this.returnData = returnData;
    }
}