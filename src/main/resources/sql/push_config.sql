/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : information_push

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-04-19 13:33:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for push_config
-- ----------------------------
DROP TABLE IF EXISTS `push_config`;
CREATE TABLE `push_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_by` int(11) DEFAULT NULL COMMENT '修改人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) DEFAULT NULL COMMENT '0未删除  1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of push_config
-- ----------------------------
INSERT INTO `push_config` VALUES ('1', 'localhost/host', 'sendmeth', '1', '1', '2019-04-19 09:43:16', '2019-04-19 09:43:18', '0');
INSERT INTO `push_config` VALUES ('2', '127.0.0.1', 'asdfsda', '1', '1', '2019-04-19 13:22:44', '2019-04-19 13:22:47', '0');
