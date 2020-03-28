package com.ty.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 聊天窗用户关联表
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MessageWindowUser implements Serializable {


    @TableId(value = "message_window_id", type = IdType.INPUT)
    private String messageWindowId;

    private String userId;


}
