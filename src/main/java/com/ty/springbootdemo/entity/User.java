package com.ty.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 好友分组与好友关联表
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    private String name;

    private String password;

    private Boolean gender;

    private String birthday;


}
