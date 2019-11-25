package com.bin.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Book {
    private Integer bookId;

    @NotBlank(message = "书名不能为空")
    private String bookName;

    @NotBlank(message = "作者不能为空")
    private String bookAuthor;

    @NotBlank(message = "出版社不能为空")
    private String bookPublish;

    @NotNull(message = "种类不能为空")
    private Integer bookCategory;

    private Double bookPrice;

    private String bookIntroduction;

    @NotNull(message = "数量不能为空")
    private Integer bookNum;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public Integer getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(Integer bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }
}