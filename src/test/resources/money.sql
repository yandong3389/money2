/*
Navicat MySQL Data Transfer

Source Server         : money_db
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : money_db

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2015-03-02 16:17:25
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
INSERT INTO `admin` VALUES ('1', 'admin1', 'admin1', '管理员1', 'admin1', '');
INSERT INTO `admin` VALUES ('2', 'admin2', 'admin2', '管理员2', 'admin2', '');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of args
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
