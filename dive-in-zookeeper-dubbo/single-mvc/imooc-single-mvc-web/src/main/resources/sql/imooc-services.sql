/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : imooc-services

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-02-14 22:52:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` varchar(64) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '商品名称',
  `counts` int(6) NOT NULL COMMENT '商品价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '台式机', '2');
INSERT INTO `items` VALUES ('2', '笔记本', '98');
INSERT INTO `items` VALUES ('3', '背包', '6');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(64) NOT NULL,
  `order_num` varchar(64) NOT NULL COMMENT '订单号',
  `item_id` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_orders_1` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('fd57154052e644f7bccbcb59b38ef6ab', 'fd57154052e644f7bccbcb59b38ef6ab', '2');
