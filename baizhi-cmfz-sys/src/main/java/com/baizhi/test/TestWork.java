package com.baizhi.test;

import com.baizhi.service.WorkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Lenovo on 2017/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestWork {
    @Autowired
    private WorkService workService;

    @Test
    public void testSelectAll(){
        System.out.println(workService.selectAll(1,1).getRows().get(0));
    }


}
