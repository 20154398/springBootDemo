package com.ty.springbootdemo.service.impl;

import com.ty.springbootdemo.entity.Message;
import com.ty.springbootdemo.mapper.MessageMapper;
import com.ty.springbootdemo.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 聊天窗表 服务实现类
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
