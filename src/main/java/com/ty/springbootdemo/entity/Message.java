package com.ty.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 聊天窗表
 * </p>
 *
 * @author yuan
 * @since 2020-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Message implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 消息体
     */
    private String content;

    /**
     * 发送方
     */
    private String sendUserId;

    /**
     * 接收方
     */
    private String windowId;

    /**
     * 创建时间
     */
    private LocalDateTime creatTime;

    /**
     * 是否撤销
     */
    private Boolean deleteFlag;


}
