package com.ty.springbootdemo.service.impl;

import com.ty.springbootdemo.entity.MessageWindowUser;
import com.ty.springbootdemo.mapper.MessageWindowUserMapper;
import com.ty.springbootdemo.service.MessageWindowUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 聊天窗用户关联表 服务实现类
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */
@Service
public class MessageWindowUserServiceImpl extends ServiceImpl<MessageWindowUserMapper, MessageWindowUser> implements MessageWindowUserService {

}
