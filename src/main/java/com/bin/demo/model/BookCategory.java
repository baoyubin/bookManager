package com.bin.demo.model;

import javax.validation.constraints.NotBlank;

public class BookCategory {

    private Integer categoryId;

    @NotBlank(message = "种类不能为空")
    private String categoryName;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}