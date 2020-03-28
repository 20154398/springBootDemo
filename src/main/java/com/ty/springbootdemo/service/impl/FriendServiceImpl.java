package com.ty.springbootdemo.service.impl;

import com.ty.springbootdemo.entity.Friend;
import com.ty.springbootdemo.mapper.FriendMapper;
import com.ty.springbootdemo.service.FriendService;
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
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

}
