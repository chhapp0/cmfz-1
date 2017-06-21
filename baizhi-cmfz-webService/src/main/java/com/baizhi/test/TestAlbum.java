package com.baizhi.test;

import com.baizhi.dao.AlbumMapper;
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
public class TestAlbum {

    @Autowired
    private AlbumMapper albumMapper;


    @Test
    public void testSelectById(){
        System.out.println(albumMapper.selectByPrimaryKey("ae7e4af6-4ccf-4be1-b4a1-766d4d437189"));
    }
}
