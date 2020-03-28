package com.ty.springbootdemo.controller;

import com.ty.springbootdemo.entity.TestTable;
import com.ty.springbootdemo.entity.User;
import com.ty.springbootdemo.message.CodeMsg;
import com.ty.springbootdemo.message.Result;
import com.ty.springbootdemo.service.UserService;
import com.ty.springbootdemo.util.UUIDUtils;
import com.ty.springbootdemo.util.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 好友分组与好友关联表 前端控制器
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/insert")
    public Result insert(String name, String password, Boolean gender, String birthday) {
        if (Objects.equals(null, name)) {
            return Result.error(CodeMsg.USER_NOT_EXITS);
        }
        if (Objects.equals(null, password)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        try {
            userService.save(new User()
                    .setId(UUIDUtils.getInstance().getUUID())
                    .setName(name)
                    .setPassword(Utils.getInstance().deCode(password))
                    .setGender(gender)
                    .setBirthday(birthday));
        } catch (Exception e) {
            return Result.error(CodeMsg.FAIL);
        }
        return Result.success("成功插入");
    }

    @GetMapping("/getAll")
    public Result getAll() {
        List<User> allUser = userService.list();
//        allUser.forEach(d->{
//            d.setPassword(Utils.getInstance().enCode(d.getPassword()));
//        });
        return Result.success(allUser);
    }
}
