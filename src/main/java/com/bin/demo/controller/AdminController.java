package com.bin.demo.controller;

import com.bin.demo.model.Admin;
import com.bin.demo.model.Book;
import com.bin.demo.model.BookCategory;
import com.bin.demo.model.User;
import com.bin.demo.model.VO.BookVo;
import com.bin.demo.service.IAdminService;
import com.bin.demo.service.IBookService;
import com.bin.demo.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    private IAdminService iAdminService;

    /**
     * 登录
     * @param adminName
     * @param password
     * @param request
     * @return
     */
    @GetMapping("/adminLogin")
    public String adminLogin(String adminName, String password, HttpServletRequest request){
        Admin res=iAdminService.adminLogin(adminName,password);
        if(res == null ){
            return "admin";
        }
        request.getSession().setAttribute("admin",res);
        return "admin/index";
    }

    /**
     * 管理员退出登陆
     * @return
     */
    @RequestMapping("/adminLogOut")
    public String adminLogOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "admin";
    }

    /**
     * 展示用户
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/showUsersPage")
    public String showUsersPage(Model model,@RequestParam("pageNum")int pageNum){
        PageInfo<User> page=iAdminService.findUserList(pageNum);
        model.addAttribute("page",page);
        return "admin/showUsers";
    }

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    @PostMapping("/deleteUser")
    @ResponseBody
    public String deleteUserByUserId(@RequestParam("userId") int userId){
        int res=iAdminService.deleteUserById(userId);
        if(res>0){
            return "true";
        }
        return "false";
    }
    /**
     * 添加用户界面
     * @return
     */
    @GetMapping("/addUserPage")
    public String addUsersPage(){
        return "admin/addUser";
    }
    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    @ResponseBody
    public  String addUser(@Valid User user){
        int n = iAdminService.addUser(user);
        if(n > 0) {
            return "true";
        }
        return "false";
    }


    /**
     * 返回种类界面
     * @param m
     * @param pageNum
     * @return
     */
    @GetMapping("/addCategoryPage")
    public  String addCategoryPage(Model m,@RequestParam("pageNum")int pageNum){
        PageInfo<BookCategory> page =iAdminService.findCategoryList(pageNum);
        m.addAttribute("page",page);
        return "admin/addCategory";
    }
    /**
     * 新建种类
     * @param bookCategory
     * @return
     */
    @PostMapping("/addBookCategory")
    @ResponseBody
    public String addBookCategory(@Valid BookCategory bookCategory){
        boolean b=iAdminService.addBookCategory(bookCategory);
        if(b){
            return "true";
        }
        return "false";
    }

    /**
     * 删除种类
     * @param categoryId
     * @return
     */
    @PostMapping("/deleteCategory")
    @ResponseBody
    public String deleteCategoryByCategoryId(@RequestParam("categoryId") int categoryId){
        int res=iAdminService.deleteCategoryById(categoryId);
        if(res>0){
            return "true";
        }
        return "false";
    }

    /**
     * 返回添加书籍页面
     * @return
     */
    @GetMapping("/addBookPage")
    public String addBookPage(){
        return "admin/addBook";
    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
    @PostMapping("/addBook")
    @ResponseBody
    public String addBook(@Valid Book book){
        boolean b=iAdminService.addBook(book);
        if(b){
            return "true";
        }
        return "false";
    }

    /**
     * 删除书籍
     * @param bookId
     * @return
     */
    @PostMapping("/deleteBook")
    @ResponseBody
    public String deleteBookById(@RequestParam("bookId") int bookId){
        int res=iAdminService.deleteBookById(bookId);
        if(res>0){
            return "true";
        }
        return "false";
    }

    /**
     * 借书记录
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/BorrowingRecordPage")
    public  String allBorrowingBooksRecord(Model model, @RequestParam("pageNum")int pageNum){
        model.addAttribute("page",iAdminService.findBorrowingBooksList(pageNum));
        return "admin/showBorrowingRecord";
    }
}
