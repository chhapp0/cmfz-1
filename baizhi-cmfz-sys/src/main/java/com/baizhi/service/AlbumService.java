package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.Split;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专辑的业务层
 * Created by Lenovo on 2017/6/14.
 */
@Service

public interface AlbumService {

    //查询所有的专辑
    public Split<Album> selectAll(Integer page, Integer rows);

    //添加
    public void addAlbum(Album album);

    //删除
    public void deleteAlbum(String id);

    //修改
    public void updateAlbum(Album album);

    //查询一个专辑
    public Album selectOne(String id);

    //查询所有专辑（章节专用）
    public List<Album> selectForCha();

}
