package com.bin.demo.controller;


import com.bin.demo.model.User;
import com.bin.demo.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;

    /**
     *登录
     * @param userName
     * @param password
     * @param request
     * @return
     */

    @GetMapping("/userLogin")
    public String userLogin(@RequestParam("userSno") Integer userSno,
                            @RequestParam("password") String password, HttpServletRequest request) {
        User user = iUserService.findByUserSno(userSno);
        if(null != user){
            User res = iUserService.userLogin(user, password);
            if (null != res) {
                request.getSession().setAttribute("user", res);
                return "user/index";
            }
        }
        return "index";
    }

    /**
     *退出
     * @param request
     * @return
     */
    @RequestMapping("/userLogOut")
    public String userLogOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }


    /**
     * 返回个人信息页面
     * @return
     */
    @GetMapping("/userMessagePage")
    public String userMessagePage(Model model, HttpServletRequest request){
        User session_user= (User) request.getSession().getAttribute("user");
        User user=iUserService.findByUserSno(session_user.getUserSno());
        model.addAttribute("message_user",user);
        return "user/userMessage";
    }

    /**
     * 修改信息
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/updateUser")
    public @ResponseBody boolean updateUser(@Valid User user, HttpServletRequest request){
        User session_user = (User) request.getSession().getAttribute("user");
        user.setUserId(session_user.getUserId());
        user.setUserSno(session_user.getUserSno());
        if(iUserService.updateUser(user)){
            User newUser=iUserService.findByUserSno(session_user.getUserSno());
            request.getSession().setAttribute("user",newUser);
            return  true;
        }
        else {
            return false;
        }
    }

    /**
     * 借书记录
     * @param model
     * @param pageNum
     * @param request
     * @return
     */
    @GetMapping("/userBorrowingRecordPage")
    public  String userBorrowingBooksRecord(Model model, @RequestParam("pageNum")int pageNum,HttpServletRequest request){
        User session_user = (User) request.getSession().getAttribute("user");
        model.addAttribute("page",iUserService.findBorrowingBooks(pageNum,session_user));
        return "user/showBorrowingRecord";
    }

    /**
     * 还书
     * @param id
     * @param request
     * @return
     */
    @PostMapping("/returnBook")
    public @ResponseBody boolean returnBook(@RequestParam("id")int id, HttpServletRequest request){
        User session_user = (User) request.getSession().getAttribute("user");
        if(iUserService.returnBook(id,session_user)){
            return  true;
        }
        else {
            return false;
        }
    }

    /**
     * 借书
     * @param bookId
     * @param request
     * @return
     */
    @PostMapping("/borrowBook")
    public @ResponseBody Boolean borrowBook(@RequestParam("bookId")int bookId, HttpServletRequest request){
        User session_user = (User) request.getSession().getAttribute("user");
        if(iUserService.borrowBook(bookId,session_user)){
            return  true;
        }
        else {
            return false;
        }
    }
}

