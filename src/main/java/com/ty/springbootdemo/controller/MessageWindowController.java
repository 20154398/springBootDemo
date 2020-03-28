package com.ty.springbootdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ty.springbootdemo.entity.MessageWindow;
import com.ty.springbootdemo.service.MessageWindowService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 聊天窗表 前端控制器
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */

@RestController
@RequestMapping("/message-window")
public class MessageWindowController {

    private final MessageWindowService messageWindowService;

    public MessageWindowController(MessageWindowService messageWindowService) {
        this.messageWindowService = messageWindowService;
    }
}
