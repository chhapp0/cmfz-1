package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.entity.Split;
import com.baizhi.service.GuruService;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lenovo on 2017/6/15.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Resource
    private GuruService guruService;

    @RequestMapping("/queryAll")
    @ResponseBody
    //用户信息专用
    public List<Guru> queryAll(){
        List<Guru> gurus = guruService.selectForUser();
        return gurus;
    }


    @RequestMapping("/showAll")
    @ResponseBody
    public Split<Guru> showAll(Integer page,Integer rows){

        Split<Guru> guruSplit = guruService.selectAll(page, rows);
        return guruSplit;

    }

    @RequestMapping("/addGuru")
    public void addGuru(Guru guru, HttpServletRequest request, MultipartFile pic) throws IOException {
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
        guru.setHead(webapps + "\\files\\"+newName+contentType.split("/")[1]);

        guruService.addGuru(guru);
    }
    @RequestMapping("/deleteGuru")
    public void deleteGuru(String id){
        guruService.deleteGuru(id);
    }

    @RequestMapping("/updateGuru")
    public void updateGuru(Guru guru,HttpServletRequest request, MultipartFile pic) throws IOException {
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
        guru.setHead(webapps + "\\files\\"+newName+contentType.split("/")[1]);
        guruService.updateGure(guru);
    }

    @ResponseBody
    @RequestMapping("/queryOne")
    public Guru queryOne(String id){
        Guru guru = guruService.selectOne(id);
        return guru;
    }




}
