-- ----------------------------
-- Table structure for WECHAT_TEMPLATE
-- ----------------------------
DROP TABLE IF EXISTS `WECHAT_TEMPLATE`;
CREATE TABLE `WECHAT_TEMPLATE` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `WT_TEMPLATE_ID` varchar(50) NOT NULL COMMENT '模板标识',
  `WT_BUSINESS_TYPE` varchar(200) NOT NULL COMMENT '业务类型',
  `WT_CONTENT` varchar(255) NOT NULL COMMENT '配置内容',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板配置表';

-- ----------------------------
-- Records of WECHAT_TEMPLATE
-- ----------------------------
INSERT INTO `WECHAT_TEMPLATE` VALUES ('15266e12edde11e6a00a00188b839ae8', 'UcKRiZtOHv1nZYF-V8o9kw7kxRZ-q-IBBL5A67kzNaU', 'wx_bind_success', 'first:content:#000000;keyword1:receiver:#aaaaaa;keyword2:addition:#aaaaaa');
