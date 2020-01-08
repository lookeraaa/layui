/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : layui

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-01-08 23:06:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` int(1) DEFAULT NULL COMMENT '父id',
  `name` varchar(50) NOT NULL COMMENT '权限名称',
  `permcode` varchar(255) DEFAULT NULL,
  `type` int(1) NOT NULL COMMENT '权限类型：1：菜单 0：功能',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `url` varchar(255) DEFAULT NULL COMMENT '菜单的url地址',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '0', '系统管理', '', '1', '1', '#', '');
INSERT INTO `permission` VALUES ('2', '1', '用户管理', '', '1', '1', '/system/userList', '');
INSERT INTO `permission` VALUES ('3', '1', '角色管理', null, '1', '2', '/system/roleList', null);
INSERT INTO `permission` VALUES ('4', '1', '权限管理', null, '1', '3', '/system/permissionList', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) NOT NULL COMMENT '角色名',
  `rolecode` varchar(20) NOT NULL COMMENT '角色编码',
  `description` varchar(0) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', 'admin', '', '1');
INSERT INTO `role` VALUES ('2', '系统测试员', 'test', null, '2');

-- ----------------------------
-- Table structure for rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleid` int(11) NOT NULL COMMENT '角色ID',
  `permisionid` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES ('1', '1', '1');
INSERT INTO `rolepermission` VALUES ('2', '1', '2');
INSERT INTO `rolepermission` VALUES ('4', '1', '3');
INSERT INTO `rolepermission` VALUES ('5', '1', '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL COMMENT '登录账号',
  `name` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(30) DEFAULT NULL COMMENT '加密salt',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `phone` varchar(100) DEFAULT NULL COMMENT '电话',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(3) DEFAULT NULL COMMENT '性别',
  `adddate` datetime DEFAULT NULL COMMENT '创建日期',
  `enabled` decimal(65,30) DEFAULT NULL COMMENT '是否启用',
  `remark` varchar(400) DEFAULT NULL COMMENT '备注',
  `headportrait` varchar(255) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '超级管理员', 'admin', null, '超级管理员', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('2', 'user', '测试用户', 'user', null, '测试用户', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `roleid` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1', '1', '1');
INSERT INTO `userrole` VALUES ('2', '2', '2');
