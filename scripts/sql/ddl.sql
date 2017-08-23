/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : wechat

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-08-23 09:34:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wechat_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `wechat_sys_user`;
CREATE TABLE `wechat_sys_user` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `WSU_LOGIN_NAME` varchar(32) NOT NULL COMMENT '登录名',
  `WSU_POSSWORD` varchar(32) NOT NULL COMMENT '密码',
  `WSU_REAL_NAME` varchar(32) DEFAULT NULL COMMENT '姓名',
  `WSU_PHONE` varchar(11) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of wechat_sys_user
-- ----------------------------
INSERT INTO `wechat_sys_user` VALUES ('15266e12edde11e6a00a00188b839ae8', 'yangshanghang', '123456', '杨Master', '18367829830');