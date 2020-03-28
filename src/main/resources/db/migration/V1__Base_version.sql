SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `test_table`;
CREATE TABLE `test_table`
(
    `id`          varchar(32) NOT NULL COMMENT 'ID',
    `create_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='测试';

DROP TABLE IF EXISTS `message_window`;
CREATE TABLE `message_window`
(
    `id`   varchar(32) NOT NULL,
    `name` varchar(32),
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='聊天窗表';

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`
(
    `id`           varchar(32)  NOT NULL,
    `content`      varchar(256) NOT NULL COMMENT '消息体',
    `send_user_id` varchar(32)  NOT NULL COMMENT '发送方',
    `window_id`    varchar(32)  NOT NULL COMMENT '接收方',
    `creat_time`   timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `delete_flag`  boolean   DEFAULT false COMMENT '是否撤销',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='聊天窗表';

DROP TABLE IF EXISTS `message_window_user`;
CREATE TABLE `message_window_user`
(
    `message_window_id` varchar(32) NOT NULL,
    `user_id`           varchar(32),
    PRIMARY KEY (`message_window_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='聊天窗用户关联表';

DROP TABLE IF EXISTS `friend_group`;
CREATE TABLE `friend_group`
(
    `id`      varchar(32) NOT NULL,
    `name`    varchar(32) NOT NULL,
    `user_id` varchar(32) NOT NULL COMMENT '分组属于那个用户',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='好友分组';

DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`
(
    `friend_group_id` varchar(32) NOT NULL,
    `user_id`         varchar(32) NOT NULL,
    PRIMARY KEY (`friend_group_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='好友分组与好友关联表';

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       varchar(32) NOT NULL,
    `name`     varchar(32) NOT NULL,
    `password` varchar(32) NOT NULL,
    `gender`   boolean     NOT NULL,
    `birthday` varchar(10) NOT NULL DEFAULT '1997-01-01',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='好友分组与好友关联表';

SET FOREIGN_KEY_CHECKS = 1;