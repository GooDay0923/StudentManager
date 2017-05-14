/*
Navicat MySQL Data Transfer

Source Server         : 192.168.8.188
Source Server Version : 50632
Source Host           : 192.168.8.188:3306
Source Database       : student_manager

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-05-15 00:56:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(100) NOT NULL DEFAULT '' COMMENT '加盐',
  `enable` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '启用状态 0：未启用 1：启用',
  `role_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '角色id',
  `gmt_create` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'c1f6bcb4f06759806d721bda02af65ad', 'e10e0ee1cf9098bf7c4e4535d492d076', '1', '1', '1491494303', '1491494303');
INSERT INTO `admin` VALUES ('2', 'test', 'ad8c820f16b73fe2af3eb838cf1c73c3', '6735c92f9b4590b8106ffd02869030cf', '1', '1', '1492011566', '1492011566');
INSERT INTO `admin` VALUES ('3', 'abc', 'b85145bdfd74528247482cc596bfb4a3', 'e60f7815b68968d3a957cd9a1d9bfafc', '1', '1', '1492441220', '1492441220');
INSERT INTO `admin` VALUES ('4', 'bbb', 'f5c03b6058f748c108b5d3f3e5f937ba', '02867fcf591f853c1bf46a83fa3f9f88', '1', '1', '1492528591', '1492528591');
INSERT INTO `admin` VALUES ('5', 'cc', '2bd847724df648f3d0d0aaa94b6070d9', '919173b86140316e6241166f22d079f0', '1', '1', '1492530055', '1492530055');
INSERT INTO `admin` VALUES ('6', 'kk', 'fda21e0fea1e8c5acd055e1381567113', '5747e7f59cad1e3ad9c9a02a87ca49f0', '1', '1', '1492530133', '1492530133');
INSERT INTO `admin` VALUES ('7', 'www', '90093700cb679892132146e2990215d8', '3db37b6c954b8fe3965f52b6378f29b3', '1', '1', '1492530323', '1492530323');
INSERT INTO `admin` VALUES ('8', 'nn', '6b1eef65cd69cfeae5fabc705d7114ac', '72621299b1051e6f38310e086356821e', '1', '0', '1492695169', '1492695169');
INSERT INTO `admin` VALUES ('9', 'qqq', 'cedb8bd879ecf7c766427ef6f66da024', '0316e19a13165986952f148bea62adbe', '1', '1', '1493425396', '1493425396');
INSERT INTO `admin` VALUES ('10', 'eee', 'a07a5aa6d4c4749748f6c6b95cb1c873', '380af1483e98c6c55c429bc72664eaa7', '1', '1', '1493425411', '1493425411');
INSERT INTO `admin` VALUES ('11', 'rrr', '3caa8d8f6054e07e5ee59daca5d679af', 'b50c8370e2e8847bc555363819070ed2', '1', '1', '1493425415', '1493425415');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `p_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `description` varchar(100) NOT NULL DEFAULT '' COMMENT '描述',
  `url` varchar(255) NOT NULL DEFAULT '' COMMENT 'url',
  `permission` varchar(255) NOT NULL DEFAULT '' COMMENT '权限',
  `type` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(100) NOT NULL DEFAULT '' COMMENT '菜单图标',
  `sort` smallint(1) unsigned NOT NULL DEFAULT '0' COMMENT '菜单排序',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '删除 0：否 1：是',
  `gmt_create` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '0', '系统管理', '', '', '', '0', '', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('2', '1', '管理员列表', '', 'sys/admin/list', '', '1', '', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('3', '1', '菜单管理', '', 'sys/resource/list', '', '1', '', '2', '0', '0', '0');
INSERT INTO `resource` VALUES ('4', '1', '角色管理', '', 'sys/role/list', '', '1', '', '3', '0', '0', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `gmt_create` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '', '0', '0');

-- ----------------------------
-- Table structure for role_resource_map
-- ----------------------------
DROP TABLE IF EXISTS `role_resource_map`;
CREATE TABLE `role_resource_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `resource_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '资源id',
  `role_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role_resource_map
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL DEFAULT '' COMMENT '学生名',
  `sex` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '性别 0：未知 1：男  2：女',
  `birthday` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '出生日期',
  `enrollment_date` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '入学日期',
  `gmt_create` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '修改时间',
  `create_by` varchar(20) NOT NULL DEFAULT '' COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL DEFAULT '' COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL DEFAULT '' COMMENT '学生名',
  `sex` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '性别 0：未知 1：男  2：女',
  `birthday` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '出生日期',
  `entry_date` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '入职日期',
  `gmt_create` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '修改时间',
  `create_by` varchar(20) NOT NULL DEFAULT '' COMMENT '创建人',
  `modified_by` varchar(20) NOT NULL DEFAULT '' COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_student_map
-- ----------------------------
DROP TABLE IF EXISTS `teacher_student_map`;
CREATE TABLE `teacher_student_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `teacher_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `gmt_create` int(11) unsigned NOT NULL COMMENT '创建时间',
  `gmt_modified` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of teacher_student_map
-- ----------------------------
