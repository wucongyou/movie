CREATE DATABASE `movie`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;
USE movie;

CREATE TABLE `user` (
  `id`       BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  `username` VARCHAR(50)         NOT NULL
  COMMENT '用户名',
  `password` CHAR(64)            NOT NULL
  COMMENT '加密后的密码',
  `salt`     CHAR(32)            NOT NULL
  COMMENT '盐',
  `status`   TINYINT(4)          NOT NULL DEFAULT 0
  COMMENT '状态: 0:已生效 4:已删除',
  `ctime`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `mtime`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '用户表';
