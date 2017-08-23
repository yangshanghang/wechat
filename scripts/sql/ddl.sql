/*
Navicat MySQL Data Transfer

Source Server         : wechat
Source Server Version : 50534
Source Host           : 192.168.1.254:3306
Source Database       : lpsp_wechat

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2017-05-02 18:08:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for LPSP_WECHAT_MANAGER
-- ----------------------------
DROP TABLE IF EXISTS `LPSP_WECHAT_MANAGER`;
CREATE TABLE `LPSP_WECHAT_MANAGER` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `LWM_USER_ID` varchar(32) NOT NULL COMMENT '用户ID',
  `LWM_LOGIN_NAME` varchar(32) NOT NULL COMMENT '登录名',
  `LWM_USER_NAME` varchar(32) DEFAULT NULL COMMENT '姓名',
  `LWM_MOBILE` varchar(11) DEFAULT NULL COMMENT '手机号',
  `LWM_STATUS` char(1) NOT NULL COMMENT '状态（0：失效；1：有效）',
  `LWM_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `LWM_OPERATOR` varchar(30) NOT NULL COMMENT '操作者',
  `LWM_OPERATE_TIME` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员';

-- ----------------------------
-- Records of LPSP_WECHAT_MANAGER
-- ----------------------------
INSERT INTO `LPSP_WECHAT_MANAGER` VALUES ('15266e12edde11e6a00a00188b839ae8', 'f936bac2f60e462086e578afe2c1a34b', 'wywang1025', '王晓', '15855976919', '1', '2017-04-27 14:34:18', '2017-04-21 17:14:31', '2017-04-27 14:34:29');
INSERT INTO `LPSP_WECHAT_MANAGER` VALUES ('1c4ab682d95a11e6a00a00188b839ae8', '8ee55800f0ba4b9cb3a86f6eedd7ef11', 'yangshanghang', '杨尚杭', '18367829830', '1', '2017-04-27 10:57:50', '2017-04-21 16:51:44', '2017-04-27 10:57:56');
INSERT INTO `LPSP_WECHAT_MANAGER` VALUES ('23456e12edde11e6a00a00188bedwedw', 'cb71f36662764789820758853ab5ab3f', '18567738521', '杨勇', '18567738521', '1', '2017-04-18 14:34:16', '2017-04-25 14:56:16', '2017-04-27 14:34:27');
INSERT INTO `LPSP_WECHAT_MANAGER` VALUES ('d0c48636d77311e6a00a00188b839ae8', '7bc4fc87bfb0484581404a783d1c27ec', 'yushunwei', '余顺伟', '15355033659', '1', '2017-04-27 14:34:20', '2017-04-21 17:29:50', '2017-04-27 14:34:32');
INSERT INTO `LPSP_WECHAT_MANAGER` VALUES ('e6cd9fdaf45c11e6a00a00188b839ae8', 'ebbc1f8ad8ec4771a8618d7df0651f04', '18297986180', '何敏', '18297986180', '1', '2017-04-27 14:34:24', '2017-04-21 17:25:08', '2017-04-27 14:34:35');
