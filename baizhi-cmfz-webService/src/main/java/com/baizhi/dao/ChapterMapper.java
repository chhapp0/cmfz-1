package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterMapper {
    int deleteByPrimaryKey(String id);

    int insert(Chapter record);

    Chapter selectByPrimaryKey(String id);

    int updateByPrimaryKey(Chapter record);

    public List<Chapter> selectAll();

    //根据专辑id查询对应的章节
    public List<Chapter> selectByAlbum(String id);
}