package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Choose;
import com.baizhi.service.AdminService;
import com.baizhi.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

        //Admin login = adminService.login(admin);
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isAuthenticated());

        try {
            subject.login(new UsernamePasswordToken(admin.getUsername(), admin.getPassword()));
        } catch (UnknownAccountException e) {
            System.out.println("用户名错误....");
        }catch (IncorrectCredentialsException e) {
            System.out.println("密码错误.....");
        }

        if (subject.isAuthenticated()){
            httpSession.setAttribute("admin",admin);
            choose.setTemp(true);
            return choose;
        }else{
            return choose;
        }
       /* if (login!=null){
            httpSession.setAttribute("admin",admin);
            choose.setTemp(true);
            return choose;
        }else{
            return choose;
        }*/
    }


}
