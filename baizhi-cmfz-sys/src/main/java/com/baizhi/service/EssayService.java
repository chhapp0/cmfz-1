package com.baizhi.service;

import com.baizhi.entity.Essay;
import com.baizhi.entity.Split;

/**
 * Created by Lenovo on 2017/6/15.
 */
public interface EssayService {

    public Split<Essay> selectAll(Integer page,Integer rows);

    public Split<Essay> selectByGuru(String tid,Integer page,Integer rows);

    public void addEssay(Essay essay);

    public void deleteEssay(String id);

    public void updateEssay(Essay essay);

    public Essay queryOne(String id);

}
