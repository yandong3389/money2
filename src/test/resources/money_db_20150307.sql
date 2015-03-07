/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : money_db

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-03-07 22:05:40
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
INSERT INTO `args` VALUES ('1', '45000', '30', '5', '20', '2015-3-5 11 顶替1111');

-- ----------------------------
-- Table structure for `money_history`
-- ----------------------------
DROP TABLE IF EXISTS `money_history`;
CREATE TABLE `money_history` (
  `pkid` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pkid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of money_history
-- ----------------------------

-- ----------------------------
-- Table structure for `node`
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node` (
  `id` int(11) NOT NULL DEFAULT '0',
  `parent_id` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES ('10000', '0', '1', '2015-03-07 21:59:28');

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
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
alter table user modify id integer default '10000';
alter table user modify id integer auto_increment ;
INSERT INTO `user` VALUES ('10000', '96E79218965EB72C92A549DD5A330112', 'admin', '210726199910100709', '0', '0', '111', '111', '111', '11', '男', '2015-03-06 19:10:31', '1', '1', '2015-01-26 19:10:31');

-- ----------------------------
-- Table structure for `week_end`
-- ----------------------------
DROP TABLE IF EXISTS `week_end`;
CREATE TABLE `week_end` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL COMMENT '1、没钱\r\n2、有钱没结算\r\n3、有钱已结算',
  `week_count` int(11) DEFAULT NULL,
  `sort_flag` int(11) DEFAULT NULL COMMENT '排序字段,首先有钱的排在最前面，第二排序为姓名',
  `begin_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of week_end
-- ----------------------------
