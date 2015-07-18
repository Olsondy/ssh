/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2015-07-18 10:59:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_classes
-- ----------------------------
DROP TABLE IF EXISTS `t_classes`;
CREATE TABLE `t_classes` (
  `id` varchar(36) NOT NULL,
  `t_id` varchar(36) default NULL COMMENT '教师编号',
  `name` varchar(50) default NULL COMMENT '班级名称',
  `sum_students` varchar(255) default '0',
  `create_user` varchar(10) default NULL,
  `create_date` date default NULL,
  `modify_user` varchar(10) default NULL COMMENT '修改用户',
  `modify_date` date default NULL COMMENT '修改时间',
  `active` char(1) default 'Y' COMMENT '有效 Y 无效 N',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_classes
-- ----------------------------
INSERT INTO `t_classes` VALUES ('1', null, '初一年级', null, null, null, null, null, 'Y');

-- ----------------------------
-- Table structure for t_grades
-- ----------------------------
DROP TABLE IF EXISTS `t_grades`;
CREATE TABLE `t_grades` (
  `id` varchar(36) NOT NULL,
  `s_id` varchar(36) default NULL COMMENT '学生编号',
  `t_id` varchar(36) default NULL COMMENT '教师编号',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grades
-- ----------------------------

-- ----------------------------
-- Table structure for t_students
-- ----------------------------
DROP TABLE IF EXISTS `t_students`;
CREATE TABLE `t_students` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `c_id` varchar(36) default NULL COMMENT '班级编号',
  `s_name` varchar(10) default NULL COMMENT '学生姓名',
  `pinyin` varchar(10) default NULL COMMENT '拼音码',
  `s_sex` char(1) default NULL COMMENT 'x性别',
  `birthday` date default NULL COMMENT '年龄',
  `in_date` datetime default NULL,
  `memo` varchar(255) default NULL COMMENT '备注',
  `create_user` varchar(10) default NULL,
  `create_date` date default NULL COMMENT '入学时间',
  `modify_user` varchar(10) default NULL COMMENT '修改用户',
  `modify_date` date default NULL COMMENT '修改时间',
  `active` char(1) default 'Y' COMMENT '有效 Y 无效 N',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_students
-- ----------------------------
INSERT INTO `t_students` VALUES ('8aa7f4dd4e8a2214014e8a28ac1b0000', '1', '丁勇', 'dy', '2', '2015-07-10', '2015-07-09 08:00:00', '房贷首付sd', null, '2015-07-15', '1', '2015-07-15', 'Y');
INSERT INTO `t_students` VALUES ('8aa7f4dd4e916892014e91ca00930000', '1', '琛', 'c', '1', '2015-07-15', '2015-07-10 08:00:00', '打发士大夫', null, '2015-07-15', null, '2015-07-15', 'Y');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` varchar(36) NOT NULL,
  `name` varchar(10) default NULL COMMENT '姓名',
  `pinyin` varchar(10) default NULL COMMENT '拼音码',
  `sex` char(1) default NULL COMMENT '性别',
  `telephone` varchar(11) default NULL COMMENT '联系电话',
  `address` varchar(50) default NULL COMMENT '地址',
  `is_head` char(1) default NULL COMMENT '是否是班主任',
  `create_user` varchar(10) default NULL COMMENT '创建人',
  `create_date` date default NULL,
  `modify_user` varchar(10) default NULL COMMENT '修改用户',
  `modify_date` date default NULL COMMENT '修改时间',
  `active` char(1) default 'Y' COMMENT '有效 Y 无效 N',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(36) NOT NULL,
  `login_name` varchar(10) default NULL COMMENT '用户编号',
  `login_pwd` varchar(30) default NULL COMMENT '密码',
  `user_name` varchar(30) default NULL COMMENT '用户名',
  `create_user` varchar(50) default NULL,
  `create_date` date default NULL,
  `modify_user` varchar(50) default NULL COMMENT '修改用户',
  `modify_date` date default NULL COMMENT '修改时间',
  `active` char(1) default 'Y' COMMENT '有效 Y 无效 N',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '管理员', null, null, null, null, 'Y');
