package com.ty.springbootdemo.controller;

import com.ty.springbootdemo.entity.TestTable;
import com.ty.springbootdemo.service.TestTableService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 测试 前端控制器
 * </p>
 *
 * @author yuan
 * @since 2020-03-15
 */

@RestController
@RequestMapping("/testController")
public class TestTableController {

    private final TestTableService testTableService;

    public TestTableController(TestTableService testTableService) {
        this.testTableService = testTableService;
    }

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
        return testTableService.saveOrUpdate(new TestTable().setId(id));
    }
}
