/*
Navicat MySQL Data Transfer

Source Server         : nishuai
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-07-19 10:19:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `deptid` int(11) DEFAULT NULL,
  `empStatus` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '张三', '2714763867@qq.com', '男', null, '100');
INSERT INTO `employee` VALUES ('2', '李四', '213414', '男', null, '200');
INSERT INTO `employee` VALUES ('3', '丽丽', '213541345', '女', null, '100');
INSERT INTO `employee` VALUES ('4', 'jim', '21341234', '男', null, '100');
INSERT INTO `employee` VALUES ('5', 'Tom', '32441345', '男', null, '100');
INSERT INTO `employee` VALUES ('6', 'jack', '52462476567', 'man', null, '200');
INSERT INTO `employee` VALUES ('7', 'rose', '345315415', 'woman', null, '300');
INSERT INTO `employee` VALUES ('8', '杨明', '24·234', '男', null, '200');
INSERT INTO `employee` VALUES ('9', '张丽', '233434', '女', null, '200');
INSERT INTO `employee` VALUES ('10', '503cd', 'b', '1', null, '300');
INSERT INTO `employee` VALUES ('38096', 'test_enum', 'enum@agesun.com', '1', null, '100');
INSERT INTO `employee` VALUES ('38097', 'test_enum', 'enum@agesun.com', '1', null, '100');
INSERT INTO `employee` VALUES ('38098', 'test_enum', 'enum@agesun.com', '1', null, '200');
INSERT INTO `employee` VALUES ('38101', 'test_enum1', 'enum@agesun.com', '1', null, '100');
INSERT INTO `employee` VALUES ('38102', 'test_enum', 'enum@agesun.com', '1', null, '200');
INSERT INTO `employee` VALUES ('38110', 'test_enum', 'enum@agesun.com', '1', null, '200');
INSERT INTO `employee` VALUES ('38111', 'test_enum', 'enum@agesun.com', '1', null, '200');
