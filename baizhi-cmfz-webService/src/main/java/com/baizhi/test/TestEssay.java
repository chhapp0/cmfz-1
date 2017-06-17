package com.baizhi.test;

import com.baizhi.dao.EssayMapper;
import com.baizhi.dao.GuruMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Lenovo on 2017/6/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestEssay {

    @Autowired
    private EssayMapper essayMapper;

    @Autowired
    private GuruMapper guruMapper;
    @Test
    public void testQueryAll(){
        System.out.println(essayMapper.selectAll());
        System.out.println(guruMapper.selectByPrimaryKey("ac738c1c-baf4-4c97-abfb-3b19c3a2debe"));
    }

}
