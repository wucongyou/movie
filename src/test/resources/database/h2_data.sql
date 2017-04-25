SET MODE MYSQL;
INSERT INTO `user` (`uid`, `username`, `password`, `salt`)
VALUES ('1', 'hang.su', 'hashed password', 'private salt');
INSERT INTO `user` (`uid`, `username`, `password`, `salt`)
VALUES ('2', 'tomhon', 'hashed password', 'private salt');
INSERT INTO `movie` (`name`, `description`) VALUES ('A Chinese Odyssey', '大话西游');
INSERT INTO `movie` (`name`, `description`)
VALUES ('A chain of short stories about their distance', '秒速五厘米');
