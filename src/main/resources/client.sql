/*
Navicat MySQL Data Transfer

Source Server         : debian-sys-maint
Source Server Version : 50722
Source Host           : 39.105.130.116:3306
Source Database       : test_test

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-11-27 20:07:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `client`
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `capitalid` int(11) DEFAULT NULL COMMENT '省',
  `customername` varchar(255) DEFAULT NULL COMMENT '客户名称',
  `traderid` int(11) DEFAULT NULL COMMENT '交易id',
  `agentid` int(11) DEFAULT NULL COMMENT '代理商id',
  `salesmanid` int(11) DEFAULT NULL COMMENT '销售id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=313 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('294', '11', '东阿六和绿佳食品有限公司', '2', '3', '4');
INSERT INTO `client` VALUES ('295', '1', '临沂六和虹晨农牧有限公司', '1', null, null);
INSERT INTO `client` VALUES ('296', '2', '临邑六合食品有限公司', null, null, null);
INSERT INTO `client` VALUES ('297', '4', '临邑县如泉水泥厂', null, null, null);
INSERT INTO `client` VALUES ('298', '11', '临邑县轴瓦厂', null, null, null);
INSERT INTO `client` VALUES ('299', '11', '临邑县金秋棉业加工厂', null, null, null);
INSERT INTO `client` VALUES ('300', '11', '临邑龙岩纺织有限公司', null, null, null);
INSERT INTO `client` VALUES ('301', '11', '兰陵新希望六和虹那食品有限公司', null, null, null);
INSERT INTO `client` VALUES ('302', '11', '单县六和饲料有限公司食品分公司', null, null, null);
INSERT INTO `client` VALUES ('303', '12', '博兴县中泰彩板有限公司', null, null, null);
INSERT INTO `client` VALUES ('304', '1', '博兴县宗鑫金属科技有限公司', null, null, null);
INSERT INTO `client` VALUES ('305', '1', '嘉祥新希望六和食品有限公司', null, null, null);
INSERT INTO `client` VALUES ('306', '1', '威海中威橡胶有限公司', null, null, null);
INSERT INTO `client` VALUES ('307', '1', '威海君乐轮胎有限公司', null, null, null);
INSERT INTO `client` VALUES ('308', '1', '宏祥新材料股份有限公司', null, null, null);
INSERT INTO `client` VALUES ('309', '1', '山东一鸣纺织有限公司', null, null, null);
INSERT INTO `client` VALUES ('310', '11', '山东三谊工贸有限公司', null, null, null);
INSERT INTO `client` VALUES ('311', '11', '山东三金精密铸造有限公司', null, null, null);
INSERT INTO `client` VALUES ('312', '11', '山东业丰新材料有限公司', null, null, null);

-- ----------------------------
-- Table structure for `deal`
-- ----------------------------
DROP TABLE IF EXISTS `deal`;
CREATE TABLE `deal` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `balancedate` varchar(255) DEFAULT NULL COMMENT '结算日期',
  `customerid` int(11) DEFAULT NULL COMMENT '客户关联id',
  `electric` double(5,0) DEFAULT NULL COMMENT '交易电量',
  `practical` double(5,0) DEFAULT NULL COMMENT '实际交易电量',
  `power` double(5,0) DEFAULT NULL COMMENT '偏差电量',
  `deviationratio` double(5,0) DEFAULT NULL COMMENT '偏差率',
  `assess` double(5,0) DEFAULT NULL COMMENT '考核执行偏差',
  `deviation` double(5,0) DEFAULT NULL COMMENT '偏差考核费用',
  `userfees` double(5,0) DEFAULT NULL COMMENT '用户偏差考核费用',
  `companyexpense` double(5,0) DEFAULT NULL COMMENT '代理公司考核费用',
  `discount` double(5,0) DEFAULT NULL COMMENT '优惠金额',
  `totaldiscount` double(5,0) DEFAULT NULL COMMENT '合计优惠金额',
  `remake` varchar(255) DEFAULT NULL COMMENT '备注',
  `bias` double(5,0) DEFAULT NULL COMMENT '允许偏差电量',
  `area` int(255) DEFAULT NULL COMMENT '区域',
  `declareid` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of deal
-- ----------------------------
INSERT INTO `deal` VALUES ('42', '2019-11-27', '297', '258', '258', '258', '258', '258', '258', '258', '258', '258', '258', null, '258', '2', null);
INSERT INTO `deal` VALUES ('43', '2019-11-21', '296', '0', '2', '3', '4', '6', '7', '8', '9', '10', '11', '12', '5', '1', null);
INSERT INTO `deal` VALUES ('44', '2019-11-21', '297', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', '1', null);
INSERT INTO `deal` VALUES ('45', '2019-11-19', '294', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '2', '0', '1', null);
INSERT INTO `deal` VALUES ('46', '2019-11-21', '294', '123', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', '1', null);
INSERT INTO `deal` VALUES ('47', '2019-11-22', '297', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', '1', null);
INSERT INTO `deal` VALUES ('48', '2019-11-22', '297', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1478', '0', '1', null);

-- ----------------------------
-- Table structure for `declar`
-- ----------------------------
DROP TABLE IF EXISTS `declar`;
CREATE TABLE `declar` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `declaretime` varchar(255) DEFAULT NULL COMMENT '申报日期',
  `electrotime` varchar(255) DEFAULT NULL COMMENT '用电日期',
  `electro` int(11) DEFAULT NULL COMMENT '申报电量',
  `days` int(11) DEFAULT NULL COMMENT '当月正常生产天数',
  `lastmonth` varchar(255) DEFAULT NULL COMMENT '同上月相比',
  `samemoth` varchar(255) DEFAULT NULL COMMENT '同去年相同月相比',
  `explai` varchar(255) DEFAULT NULL COMMENT '补充说明',
  `status` int(1) DEFAULT NULL COMMENT '状态  1是已申报  2是未申报   3是未开始',
  `usersid` int(11) DEFAULT NULL COMMENT '公众号的关联id',
  `electrotimeho` varchar(255) DEFAULT NULL COMMENT '用电日期后',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of declar
-- ----------------------------
INSERT INTO `declar` VALUES ('49', '2019-11-19', '2019-11-12 00:00:00', '12', '12', '1', null, '鑫', '3', '52', '2019-11-18 00:00:00');
INSERT INTO `declar` VALUES ('50', '2019-11-19', '2019-12-01 00:00:00', '12', '12', null, '2', '郑州', '3', '52', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('51', '2019-11-19', '2019-12-01 00:00:00', '12', '15', null, '1', '', '3', '53', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('52', '2019-11-19', '2019-12-01 00:00:00', '15', '15', '3', null, '还在家', '3', '54', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('53', '2019-11-19', '2019-11-11 00:00:00', '12', '12', '2', null, '12', '3', '51', '2019-11-13 00:00:00');
INSERT INTO `declar` VALUES ('54', '2019-11-19', '2019-10-28 00:00:00', '56', '56', null, '3', 'iui', '3', '54', '2019-11-04 00:00:00');
INSERT INTO `declar` VALUES ('55', '2019-11-19', '2019-12-01 00:00:00', '110', '30', null, '3', '', '3', '55', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('56', '2019-11-19', '2019-12-01', '12', '25', '1', null, '哈哈哈', '3', '51', '2019-12-31');
INSERT INTO `declar` VALUES ('57', '2019-11-20', '2019-12-01 00:00:00', '11', '12', '1', null, 'adsas', '3', '53', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('58', '2019-11-20', '2019-12-01 00:00:00', '12', '11', null, '2', 'ase', '3', '53', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('59', '2019-11-20', '2019-12-01 00:00:00', '12', '22', '1', null, 'dsss', '3', '53', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('60', '2019-11-20', '2019-12-01 00:00:00', '1', '12', '3', null, '', '3', '53', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('61', '2019-11-20', '2019-12-01 00:00:00', '20', '12', '2', null, '55555', '3', '53', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('62', '2019-11-20', '2019-12-01 00:00:00', '20', '12', '2', null, '55555', '3', '53', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('63', '2019-11-20', '2019-12-01 00:00:00', '500', '22', null, '0', '', '3', '53', '2019-12-31 00:00:00');
INSERT INTO `declar` VALUES ('64', '2019-11-20', '2019-11-13 00:00:00', '15', '15', '1', null, '12', '3', '51', '2019-11-16 00:00:00');
INSERT INTO `declar` VALUES ('65', '2019-11-20', '2019-11-11 00:00:00', null, null, '2', null, '', '3', '51', '2019-11-18 00:00:00');
INSERT INTO `declar` VALUES ('66', '2019-11-20', '2019-11-21 00:00:00', null, null, null, '2', '', '3', '51', '2019-11-14 00:00:00');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `departmentname` varchar(255) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '交易部');
INSERT INTO `department` VALUES ('2', '开发部');

-- ----------------------------
-- Table structure for `jurisdiction`
-- ----------------------------
DROP TABLE IF EXISTS `jurisdiction`;
CREATE TABLE `jurisdiction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `text` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `url` varchar(255) DEFAULT NULL COMMENT '路径',
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of jurisdiction
-- ----------------------------
INSERT INTO `jurisdiction` VALUES ('1', '管理', null, '0');
INSERT INTO `jurisdiction` VALUES ('2', '查询', null, '1');
INSERT INTO `jurisdiction` VALUES ('3', '权限', null, '0');
INSERT INTO `jurisdiction` VALUES ('4', '差', null, '3');

-- ----------------------------
-- Table structure for `region`
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `region` varchar(255) DEFAULT NULL COMMENT '地区',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES ('1', '北京');
INSERT INTO `region` VALUES ('2', '上海');
INSERT INTO `region` VALUES ('3', '广东');
INSERT INTO `region` VALUES ('4', '深圳');
INSERT INTO `region` VALUES ('5', '河南');
INSERT INTO `region` VALUES ('6', '新疆');
INSERT INTO `region` VALUES ('7', '厦门');
INSERT INTO `region` VALUES ('8', '广西');
INSERT INTO `region` VALUES ('10', '安徽');
INSERT INTO `region` VALUES ('11', '山东');
INSERT INTO `region` VALUES ('12', '黑龙江');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  `rolename` varchar(255) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '交易员');
INSERT INTO `role` VALUES ('2', '销售负责人');
INSERT INTO `role` VALUES ('3', '代理商');
INSERT INTO `role` VALUES ('4', '超级管理员');

-- ----------------------------
-- Table structure for `role_jurisdiction`
-- ----------------------------
DROP TABLE IF EXISTS `role_jurisdiction`;
CREATE TABLE `role_jurisdiction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  `jurisdictionid` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role_jurisdiction
-- ----------------------------
INSERT INTO `role_jurisdiction` VALUES ('1', '1', '1');
INSERT INTO `role_jurisdiction` VALUES ('2', '2', '1');
INSERT INTO `role_jurisdiction` VALUES ('3', '2', '2');
INSERT INTO `role_jurisdiction` VALUES ('4', '1', '2');
INSERT INTO `role_jurisdiction` VALUES ('5', '2', '3');
INSERT INTO `role_jurisdiction` VALUES ('6', '2', '4');

-- ----------------------------
-- Table structure for `trader`
-- ----------------------------
DROP TABLE IF EXISTS `trader`;
CREATE TABLE `trader` (
  `id` int(11) NOT NULL COMMENT '主键',
  `trader` varchar(255) DEFAULT NULL COMMENT '交易员名称',
  `traderphone` varchar(255) DEFAULT NULL COMMENT '交易员电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of trader
-- ----------------------------
INSERT INTO `trader` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typename` varchar(255) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '电力用户');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '账号\r\n账号',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `thistime` varchar(255) DEFAULT NULL COMMENT '本次登录时间',
  `lasttime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `accountstatus` int(1) DEFAULT NULL COMMENT '账号状态 1是启用  2是未启用',
  `departmentid` int(11) DEFAULT NULL COMMENT '部门关联id',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `region` varchar(255) DEFAULT NULL COMMENT '登录ip地址',
  `roleid` int(11) DEFAULT NULL COMMENT 'id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '飞洒发发', '123', '123', '2019-11-20 16:57:45', null, '1', '1', '李四', '127.0.0', null);
INSERT INTO `user` VALUES ('3', '阿斯弗', '45', '42', null, '2019-11-29 16:57:55', '2', '1', '阿斯弗', '127.0.0', null);
INSERT INTO `user` VALUES ('4', '发大水', '524', '12', '2019-11-22 16:57:49', null, '1', '1', '飞洒范德萨斯弗', '127.0.0', null);
INSERT INTO `user` VALUES ('5', '放大', 'bb', 'bb', null, null, '1', '1', 'mm答复', 'we', null);
INSERT INTO `user` VALUES ('6', '张三', '224', '123', null, '2019-11-26 16:57:52', '1', '1', '1安抚', '127.0.0', null);
INSERT INTO `user` VALUES ('7', '李四', '24', '123', null, null, '1', '1', '2放大', '127.0.0', null);
INSERT INTO `user` VALUES ('8', '王五', '42', '213', null, null, '1', '1', '1撒地方', '127.0.0', null);
INSERT INTO `user` VALUES ('9', '的撒', 'we', '2131', '2019-11-04 18:00:56', '2019-12-12 15:13:11', '1', '1', 'ww地方', null, null);
INSERT INTO `user` VALUES ('10', '放大', 'aa', 'aa', null, null, '1', '1', 'aa对对', '123', null);
INSERT INTO `user` VALUES ('12', '18501046077', '18501046077', '123', null, null, '1', '14', 'aa', null, null);
INSERT INTO `user` VALUES ('13', '18310447573', '18310447573', '123', null, null, '1', '1', '小马', null, null);
INSERT INTO `user` VALUES ('14', '15321133506', '15321133506', '123', null, null, '1', null, null, null, null);

-- ----------------------------
-- Table structure for `user_region`
-- ----------------------------
DROP TABLE IF EXISTS `user_region`;
CREATE TABLE `user_region` (
  `userid` int(11) NOT NULL,
  `regionid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_region
-- ----------------------------
INSERT INTO `user_region` VALUES ('14', '1');
INSERT INTO `user_region` VALUES ('14', '4');
INSERT INTO `user_region` VALUES ('14', '2');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '1', '2');
INSERT INTO `user_role` VALUES ('3', '1', '3');
INSERT INTO `user_role` VALUES ('4', '1', '4');
INSERT INTO `user_role` VALUES ('5', '2', '5');
INSERT INTO `user_role` VALUES ('6', '2', '6');
INSERT INTO `user_role` VALUES ('7', '2', '7');
INSERT INTO `user_role` VALUES ('8', '3', '8');
INSERT INTO `user_role` VALUES ('9', '3', '9');
INSERT INTO `user_role` VALUES ('10', '3', '10');
INSERT INTO `user_role` VALUES ('11', '1', '14');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `calculate` varchar(255) DEFAULT NULL COMMENT '账号',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `cellphone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `typeid` int(255) DEFAULT NULL COMMENT '类型外键',
  `enterpriseid` int(11) DEFAULT NULL COMMENT '所属企业外键',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `thistime` datetime DEFAULT NULL COMMENT '添加时间',
  `lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登陆时间',
  `region` varchar(255) DEFAULT NULL COMMENT '登陆地址',
  `status` int(1) DEFAULT NULL COMMENT '是否启用 1是启用  2是不启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('51', '15036015854', '连胜利', '15036015854', '1', '309', '123456', null, '2019-11-19 11:16:00', null, '1');
INSERT INTO `users` VALUES ('52', '18310447573', '123', '18310447573', '1', '312', '123456', null, '2019-11-19 11:16:00', null, '1');
INSERT INTO `users` VALUES ('53', '武测试', '武海军', '15321133507', '1', '294', '123', null, '2019-11-19 11:16:00', null, '1');
INSERT INTO `users` VALUES ('54', '18410419512', '朱福', '18410419512', '1', '309', '123456', null, '2019-11-19 11:16:00', null, '1');
INSERT INTO `users` VALUES ('55', '123456', 'aa', '123456', '1', '309', '123456', null, '2019-11-19 12:04:56', null, '1');
INSERT INTO `users` VALUES ('56', '123456', '连胜利', '123456', '1', '298', '123456', null, '2019-11-21 13:42:28', null, '1');
INSERT INTO `users` VALUES ('57', '123456', '123456', '临邑县轴瓦厂', '1', '298', '123456', null, '2019-11-21 13:47:04', null, '1');

-- ----------------------------
-- Table structure for `zhj_dept`
-- ----------------------------
DROP TABLE IF EXISTS `zhj_dept`;
CREATE TABLE `zhj_dept` (
  `deptId` int(32) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`deptId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of zhj_dept
-- ----------------------------
INSERT INTO `zhj_dept` VALUES ('6', '11售楼部1');

-- ----------------------------
-- Table structure for `zhj_popedom`
-- ----------------------------
DROP TABLE IF EXISTS `zhj_popedom`;
CREATE TABLE `zhj_popedom` (
  `MID` int(32) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(500) DEFAULT NULL,
  `pid` int(32) NOT NULL,
  `level` varchar(200) NOT NULL,
  `seq` int(32) DEFAULT NULL,
  `url` varchar(5000) DEFAULT NULL,
  `icon` varchar(5000) DEFAULT NULL,
  `target` varchar(500) DEFAULT NULL,
  `isParent` tinyint(1) DEFAULT NULL,
  `isMenu` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`MID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of zhj_popedom
-- ----------------------------
INSERT INTO `zhj_popedom` VALUES ('1', '客户档案', '0', '0', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('2', '客户管理', '1', '0.1', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('3', '合同管理', '0', '0', '2', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('4', '售电合同', '3', '0.3', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('5', '交易中心', '0', '0', '3', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('6', '客户结算管理', '5', '0.5', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('7', '代理商结算管理', '5', '0.5', '2', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('8', '客户电力交易结算', '5', '0.5', '3', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('9', '客户电量申报管理', '5', '0.5', '4', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('10', '代理商管理', '0', '0', '4', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('11', '代理商结算', '10', '0.10', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('12', '代理商结算-添加修改', '10', '0.10', '2', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('13', '财务管理', '0', '0', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('14', '结算依据', '13', '0.13', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('15', '系统设置', '0', '0', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('16', '账户设置', '15', '0.15', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('17', '权限管理', '0', '0', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('18', '用户列表', '17', '0.17', '1', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('19', '部门管理', '17', '0.17', '2', null, null, null, null, '1');
INSERT INTO `zhj_popedom` VALUES ('20', '角色管理', '17', '0.17', '3', null, null, null, null, '1');

-- ----------------------------
-- Table structure for `zhj_role`
-- ----------------------------
DROP TABLE IF EXISTS `zhj_role`;
CREATE TABLE `zhj_role` (
  `roleID` int(32) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`roleID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of zhj_role
-- ----------------------------
INSERT INTO `zhj_role` VALUES ('1', '超级管理员');
INSERT INTO `zhj_role` VALUES ('2', '总经理');
INSERT INTO `zhj_role` VALUES ('3', '销售员');
INSERT INTO `zhj_role` VALUES ('4', '交易员');

-- ----------------------------
-- Table structure for `zhj_role_popedom`
-- ----------------------------
DROP TABLE IF EXISTS `zhj_role_popedom`;
CREATE TABLE `zhj_role_popedom` (
  `roleID` int(32) NOT NULL,
  `mid` int(32) NOT NULL,
  `pid` int(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of zhj_role_popedom
-- ----------------------------
INSERT INTO `zhj_role_popedom` VALUES ('1', '1', '0');
INSERT INTO `zhj_role_popedom` VALUES ('1', '2', '1');
INSERT INTO `zhj_role_popedom` VALUES ('1', '17', '0');
INSERT INTO `zhj_role_popedom` VALUES ('1', '18', '17');
INSERT INTO `zhj_role_popedom` VALUES ('1', '19', '17');
INSERT INTO `zhj_role_popedom` VALUES ('1', '20', '17');
INSERT INTO `zhj_role_popedom` VALUES ('2', '1', null);
INSERT INTO `zhj_role_popedom` VALUES ('2', '2', null);

-- ----------------------------
-- Table structure for `zhj_user`
-- ----------------------------
DROP TABLE IF EXISTS `zhj_user`;
CREATE TABLE `zhj_user` (
  `userID` int(32) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(500) DEFAULT NULL,
  `loginPwd` varchar(50) DEFAULT NULL,
  `deptId` int(32) DEFAULT NULL,
  `userName` varchar(500) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `isDuty` varchar(50) DEFAULT NULL,
  `onDutyDate` datetime DEFAULT NULL,
  `offDutyDate` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `logonState` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of zhj_user
-- ----------------------------
INSERT INTO `zhj_user` VALUES ('3', '销售负责人', '121', null, '销售负责人', null, null, null, null, null, null, null);
INSERT INTO `zhj_user` VALUES ('4', '代理商', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `zhj_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `zhj_user_role`;
CREATE TABLE `zhj_user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of zhj_user_role
-- ----------------------------
INSERT INTO `zhj_user_role` VALUES ('14', '1');
INSERT INTO `zhj_user_role` VALUES ('13', '2');
