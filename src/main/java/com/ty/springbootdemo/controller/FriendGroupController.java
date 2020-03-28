package com.ty.springbootdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ty.springbootdemo.entity.FriendGroup;
import com.ty.springbootdemo.service.FriendGroupService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 好友分组 前端控制器
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */

@RestController
@RequestMapping("/friend-group")
public class FriendGroupController {

    private final FriendGroupService friendGroupService;

    public FriendGroupController(FriendGroupService friendGroupService) {
        this.friendGroupService = friendGroupService;
    }
}
