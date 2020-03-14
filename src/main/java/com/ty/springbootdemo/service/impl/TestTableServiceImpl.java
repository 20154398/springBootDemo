package com.ty.springbootdemo.service.impl;

import com.ty.springbootdemo.entity.TestTable;
import com.ty.springbootdemo.mapper.TestTableMapper;
import com.ty.springbootdemo.service.TestTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试 服务实现类
 * </p>
 *
 * @author yuan
 * @since 2020-03-14
 */
@Service
public class TestTableServiceImpl extends ServiceImpl<TestTableMapper, TestTable> implements TestTableService {

}
