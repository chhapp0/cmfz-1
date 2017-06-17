package com.baizhi.service;

import com.baizhi.dao.AlbumMapper;
import com.baizhi.dao.BannerMapper;
import com.baizhi.dao.EssayMapper;
import com.baizhi.dao.UserMapper;
import com.baizhi.entity.*;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/6/16.
 */
@Service
public class FirPageServiceImpl implements FirPageService {

    //专辑
    @Autowired
    private AlbumMapper albumMapper;

    //轮播图
    @Autowired
    private BannerMapper bannerMapper;

    //文章
    @Autowired
    private EssayMapper essayMapper;

    //用户
    @Autowired
    private UserMapper userMapper;

    public FirPageDATE makeFirPage(String uid,String type,String sub_type) {
        ArrayList<AlbumDATA> albumDATAs = new ArrayList<AlbumDATA>();
        ArrayList<BannerDATA> bannerDATAs = new ArrayList<BannerDATA>();

        //轮播图
        List<Banner> banners = bannerMapper.selectAll();
        for(Banner banner:banners){
            BannerDATA bannerDATA = new BannerDATA();
            bannerDATA.setId(banner.getId());
            bannerDATA.setThumbnail(banner.getHref());
            bannerDATA.setDescr(banner.getName());
            bannerDATAs.add(bannerDATA);
        }


        if (type.equals("all")){
            //数据库里的专辑
            List<Album> albumList = albumMapper.selectAll();

            for(Album album:albumList){
                AlbumDATA albumDATA = new AlbumDATA();
                albumDATA.setId(album.getId());
                albumDATA.setAuthor(album.getAuthor());
                albumDATA.setCreate_date(album.getCreatedate());
                albumDATA.setThumbnail(album.getThumbnail());
                albumDATA.setTitle(album.getTitle());
                albumDATA.setType(0);
                albumDATA.setSet_count(albumMapper.countOfChapter(album.getId()));
                albumDATAs.add(albumDATA);
            }

            //文章
            List<Essay> essays = essayMapper.selectAll();
            for(Essay essay:essays){
                AlbumDATA albumDATA = new AlbumDATA();
                albumDATA.setId(essay.getId());
                albumDATA.setAuthor(essay.getGuru().getName());
                albumDATA.setCreate_date(essay.getPubdate());
                albumDATA.setThumbnail(essay.getLink());
                albumDATA.setTitle(essay.getTitle());
                albumDATA.setType(1);
                albumDATAs.add(albumDATA);
            }
        }else {
            if (type.equals("si")){

                if (sub_type.equals(("xmfy"))){
                    //文章
                    List<Essay> essays = essayMapper.selectAll();
                    for(Essay essay:essays){
                        AlbumDATA albumDATA = new AlbumDATA();
                        albumDATA.setId(essay.getId());
                        albumDATA.setAuthor(essay.getGuru().getName());
                        albumDATA.setCreate_date(essay.getPubdate());
                        albumDATA.setThumbnail(essay.getLink());
                        albumDATA.setTitle(essay.getTitle());
                        albumDATA.setType(1);
                        albumDATAs.add(albumDATA);
                    }
                }
                else{
                    List<Essay> essays = userMapper.selectByPrimaryKey(uid).getGuru().getEssays();
                    for(Essay essay:essays){
                        AlbumDATA albumDATA = new AlbumDATA();
                        albumDATA.setId(essay.getId());
                        albumDATA.setAuthor(essay.getGuru().getName());
                        albumDATA.setCreate_date(essay.getPubdate());
                        albumDATA.setThumbnail(essay.getLink());
                        albumDATA.setTitle(essay.getTitle());
                        albumDATA.setType(1);
                        albumDATAs.add(albumDATA);
                    }
                }
            }else {
                //数据库里的专辑
                List<Album> albumList = albumMapper.selectAll();

                for(Album album:albumList){
                    AlbumDATA albumDATA = new AlbumDATA();
                    albumDATA.setId(album.getId());
                    albumDATA.setAuthor(album.getAuthor());
                    albumDATA.setCreate_date(album.getCreatedate());
                    albumDATA.setThumbnail(album.getThumbnail());
                    albumDATA.setTitle(album.getTitle());
                    albumDATA.setType(0);
                    albumDATA.setSet_count(albumMapper.countOfChapter(album.getId()));
                    albumDATAs.add(albumDATA);
                }
            }

        }
        FirPageDATE firPageDATE = new FirPageDATE();

        firPageDATE.setBody(albumDATAs);
        firPageDATE.setHeader(bannerDATAs);

        return firPageDATE;
    }

    public User selectByPhone(String phone) {
        User user = userMapper.selectByPhone(phone);
        return user;
    }


}
