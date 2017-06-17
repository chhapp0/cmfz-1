package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Split;
import com.baizhi.service.AlbumService;
import com.baizhi.service.BannerService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lenovo on 2017/6/13.
 */
@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/selectForCha")
    @ResponseBody
    //查询所有的专辑
    public List<Album> selectForCha(){
        List<Album> albumList = albumService.selectForCha();
        return albumList;
    }


    @RequestMapping("/showAll")
    @ResponseBody
    public Split<Album> showAll(Integer page, Integer rows){
        Split<Album> albumSplit = albumService.selectAll(page,rows);

        return albumSplit;
    }
    @RequestMapping("/deleteAlbum")
    public void deleteAlbum(Album album){
        albumService.deleteAlbum(album.getId());
    }
    @ResponseBody
    @RequestMapping("/queryOne")
    public Album queryOne(String id){
        Album album = albumService.selectOne(id);
        return album;
    }
    @RequestMapping("/update")
    public void update(Album album, MultipartFile pic, HttpServletRequest request) throws IOException {
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
        album.setThumbnail(webapps + "\\files\\"+newName+contentType.split("/")[1]);

        albumService.updateAlbum(album);
    }
    @RequestMapping("/addAlbum")
    public void addAlbum(Album album, MultipartFile pic, HttpServletRequest request) throws IOException {

        // 获取当前时间
        Date date = new Date();
        // 创建新文件名
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(date);
        String newName = UUID.randomUUID().toString().replace("-", "") + format+"."+ FilenameUtils.getExtension(pic.getName());

        // 查看文件大小
        long fileSize = pic.getSize();
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
        album.setThumbnail(webapps + "\\files\\"+newName+contentType.split("/")[1]);
        albumService.addAlbum(album);
    }


}
