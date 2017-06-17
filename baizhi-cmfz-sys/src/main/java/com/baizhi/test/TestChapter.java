package com.baizhi.test;

import com.baizhi.dao.ChapterMapper;
import com.baizhi.entity.Chapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Lenovo on 2017/6/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestChapter {

    @Autowired
    private ChapterMapper chapterMapper;

    @Test
    public void testSelectAll(){
        System.out.println(chapterMapper.selectByPrimaryKey("1"));

    }


}
