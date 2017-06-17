package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Choose;
import com.baizhi.service.AdminService;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Lenovo on 2017/6/12.
 */

@Controller

@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/login")
    public Choose login(Admin admin, HttpSession httpSession){
        Choose choose = new Choose(false);

        Admin login = adminService.login(admin);
        if (login!=null){
            httpSession.setAttribute("admin",admin);
            choose.setTemp(true);
            return choose;
        }else{
            return choose;
        }
    }


}
