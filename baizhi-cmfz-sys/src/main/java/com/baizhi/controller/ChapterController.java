package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.entity.Split;
import com.baizhi.service.ChapterService;
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
 * Created by Lenovo on 2017/6/14.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/showAll")
    @ResponseBody
    public Split<Chapter> showAll(Integer page, Integer rows){
        Split<Chapter> chapterSplit = chapterService.selectAll(page, rows);

        return chapterSplit;
    }

    @RequestMapping("addChapter")
    public void addChapter(Chapter chapter, MultipartFile cha, HttpServletRequest request) throws IOException {
        // 获取当前时间
        Date date = new Date();
        // 创建新文件名
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(date);
        String newName = UUID.randomUUID().toString().replace("-", "") + format+"."+ FilenameUtils.getExtension(cha.getName());
        // 获取文件类型
        String contentType = cha.getContentType();
        // 获取服务器的根目录
        String realPath = request.getSession().getServletContext().getRealPath("/");

        // 获取父亲目录
        String webapps = new File(realPath).getParent();
        // 自动创建文件夹
        File file = new File(webapps + "/files");
        if (!file.exists()) {
            file.mkdirs();
        }
        cha.transferTo(new File(webapps + "/files",newName+contentType.split("/")[1]));
        chapter.setUrl(webapps + "\\files\\"+newName+contentType.split("/")[1]);
        chapter.setCsize(String.valueOf(cha.getSize()));

        chapterService.addChapter(chapter);
    }

    @RequestMapping("/deleteChapter")
    public void deleteChapter(Chapter chapter){

        chapterService.deleteChapter(chapter.getId());

    }

    @RequestMapping("/updateChapter")
    public void updateChapter(Chapter chapter, MultipartFile cha, HttpServletRequest request) throws IOException {

        // 获取当前时间
        Date date = new Date();
        // 创建新文件名
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(date);
        String newName = UUID.randomUUID().toString().replace("-", "") + format+"."+ FilenameUtils.getExtension(cha.getName());
        // 获取文件类型
        String contentType = cha.getContentType();
        // 获取服务器的根目录
        String realPath = request.getSession().getServletContext().getRealPath("/");

        // 获取父亲目录
        String webapps = new File(realPath).getParent();
        // 自动创建文件夹
        File file = new File(webapps + "/files");
        if (!file.exists()) {
            file.mkdirs();
        }
        cha.transferTo(new File(webapps + "/files",newName+contentType.split("/")[1]));
        chapter.setUrl(webapps + "\\files\\"+newName+contentType.split("/")[1]);
        chapter.setCsize(String.valueOf(cha.getSize()));

        chapterService.updateChapter(chapter);

    }
    @ResponseBody
    @RequestMapping("/queryOne")
    public Chapter queryOne(String id){

        Chapter chapter = chapterService.selectOne(id);

        return chapter;
    }


}
