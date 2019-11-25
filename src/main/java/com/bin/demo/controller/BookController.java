package com.bin.demo.controller;

import com.bin.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    IBookService iBookService;

    /**
     * 管理员查询书籍
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/showBookPage")
    public  String showBookPage(Model model, @RequestParam("pageNum")int pageNum){
        model.addAttribute("page",iBookService.findBookVoList(pageNum));
        return "admin/showBooks";
    }

    /**
     * 用户查询书籍
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/showUserBookPage")
    public  String showUserBookPage(Model model, @RequestParam("pageNum")int pageNum){
        model.addAttribute("page",iBookService.findBookVoList(pageNum));
        return "user/showBooks";
    }
}
