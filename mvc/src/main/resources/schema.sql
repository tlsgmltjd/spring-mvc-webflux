CREATE TABLE IF NOT EXISTS `tbl_user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(10) NOT NULL,
    `password` CHAR(60) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `tbl_ticket` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(10) NOT NULL,
    `count` INT NOT NULL,
    `limit_count` INT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS tbl_ticket_user (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `create_time` DATETIME(6),
     `user_id` BIGINT,
     PRIMARY KEY (`id`)
);

-- INSERT INTO `tbl_user` VALUES (1, '신희성', 'vumrra');
-- INSERT INTO `tbl_ticket` VALUES (1, '50% 할인 쿠폰', 0, 100000);