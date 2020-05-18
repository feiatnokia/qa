/*
Source Server         : QA
Source Server Version : 80020
Source Host           : 192.168.3.64:3306
Source Database       : qa

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-05-18 18:39:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for performance
-- ----------------------------
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uuid` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `project_no` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `project_name` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `api_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `api_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `api_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `number` int DEFAULT NULL,
  `average` decimal(10,2) DEFAULT NULL,
  `ninety` decimal(10,2) DEFAULT NULL,
  `min` decimal(10,2) DEFAULT NULL,
  `max` decimal(10,2) DEFAULT NULL,
  `cpu` decimal(10,2) DEFAULT NULL,
  `io` decimal(10,2) DEFAULT NULL,
  `memory` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `project_no` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for project_api
-- ----------------------------
DROP TABLE IF EXISTS `project_api`;
CREATE TABLE `project_api` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `request` tinytext COLLATE utf8mb4_general_ci,
  `response` tinytext COLLATE utf8mb4_general_ci,
  `project_no` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `project_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
