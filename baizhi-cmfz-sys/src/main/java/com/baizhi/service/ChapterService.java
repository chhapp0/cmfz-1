package com.baizhi.service;

import com.baizhi.entity.Chapter;
import com.baizhi.entity.Split;

/**
 * Created by Lenovo on 2017/6/14.
 */
public interface ChapterService {

    //查询所有的章节
    public Split<Chapter> selectAll(Integer page,Integer rows);

    //添加一个章节
    public void addChapter(Chapter chapter);

    //删除一个章节
    public void deleteChapter(String id);

    //修改
    public void updateChapter(Chapter chapter);

    //查询一个
    public Chapter selectOne(String id);

}
