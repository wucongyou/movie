SET MODE MYSQL;
-- --------------------------------------------------------

CREATE TABLE `user` (
  `id`       BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  `uid`      BIGINT(11) UNSIGNED NOT NULL
  COMMENT 'uid',
  `username` VARCHAR(50)         NOT NULL
  COMMENT '用户名',
  `password` CHAR(64)            NOT NULL
  COMMENT '加密后的密码',
  `salt`     CHAR(32)            NOT NULL
  COMMENT '盐',
  `status`   TINYINT(4)          NOT NULL DEFAULT 0
  COMMENT '状态: 0:已注册 1:已激活 2:已锁定 4:已注销',
  `ctime`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `mtime`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_uid`(`uid`),
  KEY `idx_username` (`username`)
)
  COMMENT = '用户表';
