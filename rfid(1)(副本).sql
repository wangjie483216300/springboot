/*
Navicat MySQL Data Transfer

Source Server         : 本地库
Source Server Version : 50719
Source Host           : 192.168.137.110:3306
Source Database       : RFID

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-10-14 21:07:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for TB_GOODS_COLOR
-- ----------------------------
DROP TABLE IF EXISTS `TB_GOODS_COLOR`;
CREATE TABLE `TB_GOODS_COLOR` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  `FACTORY_ID` bigint(20) DEFAULT 123 COMMENT '工厂ID',
  `GOOD_STYLE_ID` bigint(20) NOT NULL COMMENT '所属款号ID',
  `NAME` varchar(20) NOT NULL COMMENT '色号名称',
  `CODE` varchar(200) DEFAULT NULL COMMENT '色号代码',
  `_VERSION` varchar(20) DEFAULT NULL COMMENT '版本号,用于锁',
  `_CREATE_USER_ID` bigint(20) NOT NULL COMMENT '创建用户ID',
  `_CREATE_USER_NAME` varchar(20) NOT NULL COMMENT '创建用户名',
  `_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `_UPDATE_USER_ID` bigint(20) DEFAULT NULL COMMENT '更新用户ID',
  `_UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '更新用户名',
  `_UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品色号表';

-- ----------------------------
-- Table structure for TB_GOODS_INFO
-- ----------------------------
DROP TABLE IF EXISTS `TB_GOODS_INFO`;
CREATE TABLE `TB_GOODS_INFO` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  `FACTORY_ID` bigint(20) DEFAULT 123 COMMENT '工厂ID',
  `RFID` varchar(200) DEFAULT NULL COMMENT '对应RFID',
  `TYPE_ID` bigint(20) NOT NULL COMMENT '商品类型ID',
  `TYPE_NAME` varchar(20) DEFAULT NULL COMMENT '商品类型名称',
  `STYLE_ID` bigint(20) NOT NULL COMMENT '商品款号ID',
  `STYLE_NAME` varchar(20) DEFAULT NULL COMMENT '商品款号名称',
  `COLOR_ID` bigint(20) NOT NULL COMMENT '商品色号ID',
  `COLOR_NAME` varchar(20) DEFAULT NULL COMMENT '商品色号名称',
  `SIZE_ID` bigint(20) NOT NULL COMMENT '商品尺码ID',
  `SIZE_NAME` varchar(20) DEFAULT NULL COMMENT '商品尺码名称',
  `STATUS` tinyint(4) NOT NULL COMMENT '商品当前状态(1.待质检 2.返修 3.销毁 4.合格 5.入库 6.出库)',
  `_VERSION` varchar(20) DEFAULT NULL COMMENT '版本号,用于锁',
  `_CREATE_USER_ID` bigint(20) NOT NULL COMMENT '创建用户ID',
  `_CREATE_USER_NAME` varchar(20) NOT NULL COMMENT '创建用户名',
  `_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `_UPDATE_USER_ID` bigint(20) DEFAULT NULL COMMENT '更新用户ID',
  `_UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '更新用户名',
  `_UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Table structure for TB_GOODS_INVENTORY_LOG
-- ----------------------------
DROP TABLE IF EXISTS `TB_GOODS_INVENTORY_LOG`;
CREATE TABLE `TB_GOODS_INVENTORY_LOG` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  `FACTORY_ID` bigint(20) DEFAULT 123 COMMENT '工厂ID',
  `GOODS_ID` bigint(20) NOT NULL COMMENT '商品ID',
  `MANAGER_ID` bigint(20) NOT NULL COMMENT '仓库管理人ID',
  `STATUS` tinyint(4) NOT NULL COMMENT '状态(1.入库   2.出库)',
  `OUTBOUND_TYPE_ID` bigint(20) DEFAULT NULL COMMENT '出库类型ID',
  `OUTBOUND_TYPE_NAME` varchar(20) DEFAULT NULL COMMENT '出库名称',
  `_VERSION` varchar(20) DEFAULT NULL COMMENT '版本号,用于锁',
  `_CREATE_USER_ID` bigint(20) NOT NULL COMMENT '创建用户ID',
  `_CREATE_USER_NAME` varchar(20) NOT NULL COMMENT '创建用户名',
  `_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `_UPDATE_USER_ID` bigint(20) DEFAULT NULL COMMENT '更新用户ID',
  `_UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '更新用户名',
  `_UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品出入库记录表';

-- ----------------------------
-- Table structure for TB_GOODS_QA_LOG
-- ----------------------------
DROP TABLE IF EXISTS `TB_GOODS_QA_LOG`;
CREATE TABLE `TB_GOODS_QA_LOG` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  `FACTORY_ID` bigint(20) DEFAULT 123 COMMENT '工厂ID',
  `GOODS_ID` bigint(20) NOT NULL COMMENT '商品ID',
  `QA_ID` bigint(20) NOT NULL COMMENT '质检员ID',
  `TAILOR_ID` bigint(20) NOT NULL COMMENT '缝纫技师ID',
  `STATUS` tinyint(4) NOT NULL COMMENT '状态(2.返修 3.销毁 4.合格)',
  `_VERSION` varchar(20) DEFAULT NULL COMMENT '版本号,用于锁',
  `_CREATE_USER_ID` bigint(20) NOT NULL COMMENT '创建用户ID',
  `_CREATE_USER_NAME` varchar(20) NOT NULL COMMENT '创建用户名',
  `_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `_UPDATE_USER_ID` bigint(20) DEFAULT NULL COMMENT '更新用户ID',
  `_UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '更新用户名',
  `_UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品质检记录表';

-- ----------------------------
-- Table structure for TB_GOODS_SIZE
-- ----------------------------
DROP TABLE IF EXISTS `TB_GOODS_SIZE`;
CREATE TABLE `TB_GOODS_SIZE` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  `FACTORY_ID` bigint(20) DEFAULT 123 COMMENT '工厂ID',
  `GOODS_COLOR_ID` bigint(20) NOT NULL COMMENT '所属色号ID',
  `NAME` varchar(20) NOT NULL COMMENT '名称',
  `CODE` varchar(200) DEFAULT NULL COMMENT '代码',
  `_VERSION` varchar(20) DEFAULT NULL COMMENT '版本号,用于锁',
  `_CREATE_USER_ID` bigint(20) NOT NULL COMMENT '创建用户ID',
  `_CREATE_USER_NAME` varchar(20) NOT NULL COMMENT '创建用户名',
  `_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `_UPDATE_USER_ID` bigint(20) DEFAULT NULL COMMENT '更新用户ID',
  `_UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '更新用户名',
  `_UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品尺码表';

-- ----------------------------
-- Table structure for TB_GOODS_STYLE
-- ----------------------------
DROP TABLE IF EXISTS `TB_GOODS_STYLE`;
CREATE TABLE `TB_GOODS_STYLE` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  `FACTORY_ID` bigint(20) DEFAULT 123 COMMENT '工厂ID',
  `GOODS_TYPE_ID` bigint(20) NOT NULL COMMENT '所属商品类型ID',
  `NAME` varchar(20) NOT NULL COMMENT '款号名称',
  `CODE` varchar(200) DEFAULT NULL COMMENT '款号代码',
  `_VERSION` varchar(20) DEFAULT NULL COMMENT '版本号,用于锁',
  `_CREATE_USER_ID` bigint(20) NOT NULL COMMENT '创建用户ID',
  `_CREATE_USER_NAME` varchar(20) NOT NULL COMMENT '创建用户名',
  `_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `_UPDATE_USER_ID` bigint(20) DEFAULT NULL COMMENT '更新用户ID',
  `_UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '更新用户名',
  `_UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品款号表';

-- ----------------------------
-- Table structure for TB_GOODS_TYPE
-- ----------------------------
DROP TABLE IF EXISTS `TB_GOODS_TYPE`;
CREATE TABLE `TB_GOODS_TYPE` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  `NAME` varchar(20) NOT NULL COMMENT '类型名',
  `FACTORY_ID` bigint(20) DEFAULT 123 COMMENT '工厂ID',
  `_VERSION` varchar(20) DEFAULT NULL COMMENT '版本号,用于锁',
  `_CREATE_USER_ID` bigint(20) NOT NULL COMMENT '创建用户ID',
  `_CREATE_USER_NAME` varchar(20) NOT NULL COMMENT '创建用户名',
  `_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `_UPDATE_USER_ID` bigint(20) DEFAULT NULL COMMENT '更新用户ID',
  `_UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '更新用户名',
  `_UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类型表';

-- ----------------------------
-- Table structure for TB_OUTBOUND_TYPE
-- ----------------------------
DROP TABLE IF EXISTS `TB_OUTBOUND_TYPE`;
CREATE TABLE `TB_OUTBOUND_TYPE` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  `NAME` varchar(20) NOT NULL COMMENT '名称',
  `FACTORY_ID` bigint(20) DEFAULT 123 COMMENT '工厂ID',
  `_VERSION` varchar(20) DEFAULT NULL COMMENT '版本号,用于锁',
  `_CREATE_USER_ID` bigint(20) NOT NULL COMMENT '创建用户ID',
  `_CREATE_USER_NAME` varchar(20) NOT NULL COMMENT '创建用户名',
  `_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `_UPDATE_USER_ID` bigint(20) DEFAULT NULL COMMENT '更新用户ID',
  `_UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '更新用户名',
  `_UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出库类型表';

-- ----------------------------
-- Table structure for TB_TAILOR_INFO
-- ----------------------------
DROP TABLE IF EXISTS `TB_TAILOR_INFO`;
CREATE TABLE `TB_TAILOR_INFO` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  `FACTORY_ID` bigint(20) DEFAULT 123 COMMENT '工厂ID',
  `_VERSION` varchar(20) DEFAULT NULL COMMENT '版本号,用于锁',
  `_CREATE_USER_ID` bigint(20) NOT NULL COMMENT '创建用户ID',
  `_CREATE_USER_NAME` varchar(20) NOT NULL COMMENT '创建用户名',
  `_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `_UPDATE_USER_ID` bigint(20) DEFAULT NULL COMMENT '更新用户ID',
  `_UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '更新用户名',
  `_UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='缝纫技师信息表';
