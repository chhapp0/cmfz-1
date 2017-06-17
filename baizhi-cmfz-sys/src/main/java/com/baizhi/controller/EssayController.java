package com.baizhi.controller;

import com.baizhi.entity.Essay;
import com.baizhi.entity.Split;
import com.baizhi.service.EssayService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Lenovo on 2017/6/15.
 */
@RequestMapping("/essay")
@Controller
public class EssayController {
    @Resource
    private EssayService essayService;

    @RequestMapping("/showAll")
    @ResponseBody
    public Split<Essay> showAll(Integer page,Integer rows){
        Split<Essay> essaySplit = essayService.selectAll(page, rows);
        return essaySplit;
    }

    @ResponseBody
    @RequestMapping("/queryOne")
    public Essay queryOne(String id){
        Essay essay = essayService.queryOne(id);
        return essay;
    }

    @RequestMapping("/addEssay")
    public void addEssay(Essay essay, HttpServletRequest request, MultipartFile tex) throws IOException {

        System.out.println("contorller++++++++++++"+essay);

        // 获取当前时间
        Date date = new Date();
        // 创建新文件名
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(date);
        String newName = UUID.randomUUID().toString().replace("-", "") + format+"."+ FilenameUtils.getExtension(tex.getName());
        // 获取文件类型
        String contentType = tex.getContentType();
        // 获取服务器的根目录
        String realPath = request.getSession().getServletContext().getRealPath("/");

        // 获取父亲目录
        String webapps = new File(realPath).getParent();
        // 自动创建文件夹
        File file = new File(webapps + "/files");
        if (!file.exists()) {
            file.mkdirs();
        }
        tex.transferTo(new File(webapps + "/files",newName+contentType.split("/")[1]));
        essay.setLink(webapps + "\\files\\"+newName+contentType.split("/")[1]);
        essayService.addEssay(essay);
    }
    @RequestMapping("/deleteEssay")
    public void deleteEssay(String id){
        essayService.deleteEssay(id);
    }
    @RequestMapping("/updateEssay")
    public void updateEssay(Essay essay, HttpServletRequest request, MultipartFile tex) throws IOException {
        // 获取当前时间
        Date date = new Date();
        // 创建新文件名
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(date);
        String newName = UUID.randomUUID().toString().replace("-", "") + format+"."+ FilenameUtils.getExtension(tex.getName());
        // 获取文件类型
        String contentType = tex.getContentType();
        // 获取服务器的根目录
        String realPath = request.getSession().getServletContext().getRealPath("/");

        // 获取父亲目录
        String webapps = new File(realPath).getParent();
        // 自动创建文件夹
        File file = new File(webapps + "/files");
        if (!file.exists()) {
            file.mkdirs();
        }
        tex.transferTo(new File(webapps + "/files",newName+contentType.split("/")[1]));
        essay.setLink(webapps + "\\files\\"+newName+contentType.split("/")[1]);
        essayService.updateEssay(essay);
    }


}
