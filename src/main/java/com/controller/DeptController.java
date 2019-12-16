package com.controller;

import com.entity.Dept;
import com.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("dept")
public class DeptController {
    @Resource
    DeptService deptService;
    @RequestMapping("list")
    public String list(Model model){
        model.addAttribute("list",deptService.list());
        return "deptManager";
    }
    @RequestMapping("add")
    @ResponseBody
    public int add(Dept dept){
        return deptService.add(dept);
    }
    @RequestMapping("del")
    @ResponseBody
    public int del(Integer deptId){
        return deptService.del(deptId);
    }
    @RequestMapping("updateShow")
    @ResponseBody
    public Dept updateShow(Integer deptId){
        return deptService.findById(deptId);
    }
    @RequestMapping("updateSubmit")
    @ResponseBody
    public int updateSubmit(Dept dept){
        return deptService.update(dept);
    }
}
