package com.baizhi.test;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Lenovo on 2017/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestGuru {
    @Autowired
    private GuruService guruService;
    @Test
    public void testAdd(){
        guruService.addGuru(new Guru(null,"大神","dfsadf",null,null));
    }
    @Test
    public void testSelectAll(){
        System.out.println(guruService.selectOne("e16f99d5-6d3a-4424-8f0d-f0db0c3e0efa"));
        System.out.println(guruService.selectForUser());

    }

}
