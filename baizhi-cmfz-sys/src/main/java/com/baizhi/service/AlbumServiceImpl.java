package com.baizhi.service;

import com.baizhi.dao.AlbumMapper;
import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.Split;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lenovo on 2017/6/14.
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{


    @Autowired
    private AlbumMapper albumMapper;

    /**
     *
     * @param page 当前页码
     * @param rows 显示几列
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Split<Album> selectAll(Integer page,Integer rows) {
        //启用分页插件
        Page<Album> albumPage = PageHelper.startPage(page, rows);
        List<Album> albums = albumMapper.selectAll();

        //二次封装
        Split<Album> albumSplit = new Split<Album>();
        albumSplit.setTotal((int) albumPage.getTotal());
        albumSplit.setRows(albums);
        return albumSplit;
    }

    public void addAlbum(Album album) {
        album.setId(UUID.randomUUID().toString());
        album.setCreatedate(new Date());
        albumMapper.insert(album);
    }

    public void deleteAlbum(String id) {
        albumMapper.deleteByPrimaryKey(id);
    }

    public void updateAlbum(Album album) {
        albumMapper.updateByPrimaryKey(album);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Album selectOne(String id) {
        Album album = albumMapper.selectByPrimaryKey(id);
        return album;
    }

    public List<Album> selectForCha() {
        List<Album> albumList = albumMapper.selectAll();
        return albumList;
    }
}
