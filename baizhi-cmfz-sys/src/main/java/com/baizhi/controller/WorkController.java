package com.baizhi.controller;

import com.baizhi.entity.Split;
import com.baizhi.entity.Work;
import com.baizhi.service.WorkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Lenovo on 2017/6/15.
 */
@Controller
@RequestMapping("/work")
public class WorkController {

    @Resource
    private WorkService workService;

    @RequestMapping("/showAll")
    @ResponseBody
    public Split<Work> showAll(Integer page,Integer rows){

        Split<Work> workSplit = workService.selectAll(page, rows);
        return workSplit;

    }
    @RequestMapping("/selectOne")
    @ResponseBody
    public Work selectOne(String id){
        Work work = workService.selectOne(id);
        return work;
    }
    @RequestMapping("/addWork")
    public void addWork(Work work){
        workService.addWork(work);
    }
    @ RequestMapping("deleteWork")
    public void deleteWork(String id){
        workService.deleteWork(id);
    }

    @RequestMapping("/updateWork")
    public void updateWork(Work work){
        workService.updateWork(work);
    }

}
