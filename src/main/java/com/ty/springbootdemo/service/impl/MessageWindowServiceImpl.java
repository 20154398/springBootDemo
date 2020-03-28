package com.ty.springbootdemo.service.impl;

import com.ty.springbootdemo.entity.MessageWindow;
import com.ty.springbootdemo.mapper.MessageWindowMapper;
import com.ty.springbootdemo.service.MessageWindowService;
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
public class MessageWindowServiceImpl extends ServiceImpl<MessageWindowMapper, MessageWindow> implements MessageWindowService {

}
