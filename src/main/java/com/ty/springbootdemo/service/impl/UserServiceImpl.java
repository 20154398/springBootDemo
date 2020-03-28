package com.ty.springbootdemo.service.impl;

import com.ty.springbootdemo.entity.User;
import com.ty.springbootdemo.mapper.UserMapper;
import com.ty.springbootdemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 好友分组与好友关联表 服务实现类
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
