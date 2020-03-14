package com.ty.springbootdemo.controller;


import com.ty.springbootdemo.entity.TestTable;
import com.ty.springbootdemo.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 测试 前端控制器
 * </p>
 *
 * @author yuan
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/testController")
public class TestTableController {
    @Autowired
    private TestTableService testTableService;

    @GetMapping("/testFun")
    public String post() {
        return "hello world";
    }

    @GetMapping("/getAll")
    public List<TestTable> getAll() {
        return testTableService.list();
    }

    @PostMapping("/insert")
    public boolean insert(String id) {
        return testTableService.saveOrUpdate(new TestTable().setId(id).setCreateTime(new Date()));
    }
}
