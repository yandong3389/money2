/*
Navicat MySQL Data Transfer

Source Server         : 192.168.8.188_3306
Source Server Version : 50532
Source Host           : 192.168.8.188:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001
  
Date: 2015-02-25 17:13:49
*/

SET FOREIGN_KEY_CHECKS=0;

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
