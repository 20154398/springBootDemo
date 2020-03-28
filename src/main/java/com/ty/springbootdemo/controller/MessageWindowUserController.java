package com.ty.springbootdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ty.springbootdemo.entity.MessageWindowUser;
import com.ty.springbootdemo.service.MessageWindowUserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 聊天窗用户关联表 前端控制器
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */

@RestController
@RequestMapping("/message-window-user")
public class MessageWindowUserController {

    private final MessageWindowUserService messageWindowUserService;

    public MessageWindowUserController(MessageWindowUserService messageWindowUserService) {
        this.messageWindowUserService = messageWindowUserService;
    }
}
