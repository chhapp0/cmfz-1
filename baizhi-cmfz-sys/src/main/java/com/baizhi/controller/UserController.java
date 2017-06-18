package com.baizhi.controller;

import com.baizhi.entity.Split;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lenovo on 2017/6/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource()
    private UserService userService;

    @ResponseBody
    @RequestMapping("/showAll")
    public Split<User> showAll(Integer page,Integer rows){
        Split<User> userSplit = userService.selectAll(page, rows);
        return userSplit;
    }

    @ResponseBody
    @RequestMapping("/showForWork")
    public List<User> showForWork(Integer page,Integer rows){
        List<User> users = userService.selectForWork();
        return users;
    }


    @ResponseBody
    @RequestMapping("/selectOne")
    public User selectOne(String id){
        User user = userService.selectOne(id);
        return user;
    }
    @RequestMapping("/addUser")
    public void addUser(User user, MultipartFile pic, HttpServletRequest request) throws IOException {
        System.out.println(user);

        // 获取当前时间
        Date date = new Date();
        // 创建新文件名
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(date);
        String newName = UUID.randomUUID().toString().replace("-", "") + format+"."+ FilenameUtils.getExtension(pic.getName());
        // 获取文件类型
        String contentType = pic.getContentType();
        // 获取服务器的根目录
        String realPath = request.getSession().getServletContext().getRealPath("/");

        // 获取父亲目录
        String webapps = new File(realPath).getParent();
        // 自动创建文件夹
        File file = new File(webapps + "/files");
        if (!file.exists()) {
            file.mkdirs();
        }
        pic.transferTo(new File(webapps + "/files",newName+contentType.split("/")[1]));
        user.setPhoto(webapps + "\\files\\"+newName+contentType.split("/")[1]);
        userService.addUser(user);
    }
    @RequestMapping("/deleteUser")
    public  void deleteUser(String id){
        userService.deleteUser(id);
    }
    @RequestMapping("/updateUser")
    public void updateUser(User user, MultipartFile pic, HttpServletRequest request) throws IOException {


        // 获取当前时间
        Date date = new Date();
        // 创建新文件名
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(date);
        String newName = UUID.randomUUID().toString().replace("-", "") + format+"."+ FilenameUtils.getExtension(pic
                .getName());
        // 获取文件类型
        String contentType = pic.getContentType();
        // 获取服务器的根目录
        String realPath = request.getSession().getServletContext().getRealPath("/");

        // 获取父亲目录
        String webapps = new File(realPath).getParent();
        // 自动创建文件夹
        File file = new File(webapps + "/files");
        if (!file.exists()) {
            file.mkdirs();
        }
        pic.transferTo(new File(webapps + "/files",newName+contentType.split("/")[1]));
        user.setPhoto(webapps + "\\files\\"+newName+contentType.split("/")[1]);
        userService.updateUser(user);
    }

    @ResponseBody
    @RequestMapping("/registCount")
    public Map<String ,Object> registCount(){
        List<Integer> integers = userService.registCount();
        HashMap<String ,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("counts",integers);
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("一周内");
        strings.add("一月内");
        strings.add("一季度内");
        strings.add("半年内");
        strings.add("一年内");
        hashMap.put("dates",strings);
        return hashMap;
    }

}
