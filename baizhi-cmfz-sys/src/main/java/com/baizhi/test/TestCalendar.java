package com.baizhi.test;

import com.baizhi.dao.UserMapper;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by Lenovo on 2017/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestCalendar {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void test(){

        Calendar instance = Calendar.getInstance();
       // System.out.println(instance.getTime());

        instance.add(Calendar.YEAR,-5);

       // System.out.println(instance.getTime());

        instance.add(Calendar.DATE,1);
        //System.out.println(instance.getTime());


        System.out.println(userService.registCount());

    }

    @Test
    public void testCount() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse("2015-7-7");
        System.out.println(new Date());
        System.out.println(parse);
        System.out.println(userMapper.registCount( parse,new Date()));
    }

}
