SET MODE MYSQL;
INSERT INTO `user` (`uid`, `username`, `password`, `salt`)
VALUES ('1', 'hang.su', 'hashed password', 'private salt');
INSERT INTO `user` (`uid`, `username`, `password`, `salt`)
VALUES ('2', 'tomhon', 'hashed password', 'private salt');
INSERT INTO `movie` (`name`, `description`) VALUES ('A Chinese Odyssey', '大话西游');
INSERT INTO `movie` (`name`, `description`)
VALUES ('A Chain of Short Stories about Their Distance', '秒速五厘米');
INSERT INTO `favorite` (`user_id`, `movie_id`) VALUES (1, 1);
INSERT INTO `favorite` (`user_id`, `movie_id`) VALUES (1, 2);
INSERT INTO `favorite` (`user_id`, `movie_id`) VALUES (2, 1);
INSERT INTO `favorite` (`user_id`, `movie_id`) VALUES (2, 2);
