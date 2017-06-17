package com.baizhi.service;

import com.baizhi.dao.ChapterMapper;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.Split;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lenovo on 2017/6/14.
 */

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Split<Chapter> selectAll(Integer page, Integer rows) {
        Page<Chapter> chapter = PageHelper.startPage(page, rows);
        List<Chapter> chapters = chapterMapper.selectAll();

        Split<Chapter> chapterSplit = new Split<Chapter>();
        chapterSplit.setTotal((int) chapter.getTotal());
        chapterSplit.setRows(chapters);

        return chapterSplit;
    }

    public void addChapter(Chapter chapter) {

        System.out.println(chapter);
        chapter.setCreatedate(new Date());
        chapter.setId(UUID.randomUUID().toString());
        //写死
        chapter.setDuration("1小时");
        chapterMapper.insert(chapter);

    }

    public void deleteChapter(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }

    public void updateChapter(Chapter chapter) {
        chapterMapper.updateByPrimaryKey(chapter);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Chapter selectOne(String id) {
        Chapter chapter = chapterMapper.selectByPrimaryKey(id);
        return chapter;
    }
}
