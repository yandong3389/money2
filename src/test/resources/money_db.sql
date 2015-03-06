/*
Navicat MySQL Data Transfer

Source Server         : money_db
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : money_db

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-03-06 21:31:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '管理员账号',
  `password` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `signin_code` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户注册密钥',
  `comment` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin1', 'E00CF25AD42683B3DF678C61F42C6BDA', '管理员1', 'admin1', '');
INSERT INTO `admin` VALUES ('2', 'admin2', 'C84258E9C39059A89AB77D846DDAB909', '管理员2', 'admin2', '');

-- ----------------------------
-- Table structure for `args`
-- ----------------------------
DROP TABLE IF EXISTS `args`;
CREATE TABLE `args` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bonus` int(10) NOT NULL COMMENT '奖金',
  `tj_bonus_percent` float(5,0) NOT NULL COMMENT '推荐奖金',
  `px_bonus_percent` float(5,0) NOT NULL COMMENT '旁系奖金',
  `zx_bonus_percent` float(5,0) NOT NULL COMMENT '直系奖金',
  `comment` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of args
-- ----------------------------
INSERT INTO `args` VALUES ('1', '45000', '30', '6', '20', '2015-3-5 11 顶替1111');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `identity_card` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '身份证',
  `jsr_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '介绍人id',
  `jdr_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '节点人id',
  `nh_card` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '农行卡号',
  `tel` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '电话号',
  `address` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `code` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '邮编',
  `sex` varchar(3) COLLATE utf8_bin NOT NULL COMMENT '性别',
  `hk_time` datetime NOT NULL COMMENT '汇款时间（时分秒）',
  `admin_code` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '管理员密码',
  `comment` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `zc_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `user_pass` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '123123', '123123', null);
INSERT INTO `user_info` VALUES ('2', '柜橱地', '23', null);
INSERT INTO `user_info` VALUES ('3', '柜橱地', '23', null);
INSERT INTO `user_info` VALUES ('4', '22222222', '2222222222222', null);
INSERT INTO `user_info` VALUES ('5', '22222222', '2222222222222', null);
INSERT INTO `user_info` VALUES ('6', '22222222', '2222222222222', null);
INSERT INTO `user_info` VALUES ('7', '火柴天堂', '12有212', null);
INSERT INTO `user_info` VALUES ('8', '火柴天堂', '12有212', null);
INSERT INTO `user_info` VALUES ('9', '火柴天堂', '12有212', null);
INSERT INTO `user_info` VALUES ('10', '火柴天堂', '12有212', null);
INSERT INTO `user_info` VALUES ('11', '火柴天堂', '12有212', null);
INSERT INTO `user_info` VALUES ('12', '火柴天堂', '12有212', null);
INSERT INTO `user_info` VALUES ('13', '火柴天堂', '12有212', null);
INSERT INTO `user_info` VALUES ('14', '火柴天堂', '12有212', null);
INSERT INTO `user_info` VALUES ('15', '火柴天堂', '12有212', null);
INSERT INTO `user_info` VALUES ('16', '火柴天堂123123', '12有21212312111111111111', null);
INSERT INTO `user_info` VALUES ('17', '火柴天堂123123', '12有21212312111111111111', null);
INSERT INTO `user_info` VALUES ('18', '123123', '34234234', null);
INSERT INTO `user_info` VALUES ('19', '1123test', '123123123test', null);
INSERT INTO `user_info` VALUES ('20', '1123test', '123123123test', null);
INSERT INTO `user_info` VALUES ('21', 'testTX', 'testTxxxx', null);
INSERT INTO `user_info` VALUES ('22', 'testTX', 'testTxxxx', null);
INSERT INTO `user_info` VALUES ('23', '23123', '23123123', null);
INSERT INTO `user_info` VALUES ('24', '23123', '23123123', null);
INSERT INTO `user_info` VALUES ('25', '2888888888888', '8888888888888', null);
INSERT INTO `user_info` VALUES ('26', '2888888888888', '8888888888888', null);
INSERT INTO `user_info` VALUES ('27', 'www', 'www', null);
INSERT INTO `user_info` VALUES ('28', 'www', 'www', null);
INSERT INTO `user_info` VALUES ('29', '`````````````````````', '11111111111111```````````', null);
INSERT INTO `user_info` VALUES ('30', '12', '12e12e', null);
