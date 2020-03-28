package com.ty.springbootdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ty.springbootdemo.entity.Friend;
import com.ty.springbootdemo.service.FriendService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 好友分组与好友关联表 前端控制器
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */

@RestController
@RequestMapping("/friend")
public class FriendController {

    private final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }
}
