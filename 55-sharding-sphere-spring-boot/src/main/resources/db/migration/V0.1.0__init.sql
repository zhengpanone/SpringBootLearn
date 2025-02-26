SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `t_order0`;
CREATE TABLE `t_order0`  (
                             `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `user_id` int(11) NOT NULL,
                             `order_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                             PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

DROP TABLE IF EXISTS `t_order1`;
CREATE TABLE `t_order1`  (
                             `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `user_id` int(11) NOT NULL,
                             `order_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                             PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

DROP TABLE IF EXISTS `t_order2`;
CREATE TABLE `t_order2`  (
                             `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `user_id` int(11) NOT NULL,
                             `order_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                             PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;