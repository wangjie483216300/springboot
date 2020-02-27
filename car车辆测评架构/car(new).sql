
DROP TABLE IF EXISTS `PERSONAL_CENTER`;
CREATE TABLE `PERSONAL_CENTER` (
  `ID` bigint(20) NOT NULL COMMENT '用户id',
  `PASSWORD` bigint(20) NOT NULL COMMENT '密码',
  `USER_NAME` varchar(20) NOT NULL COMMENT '用户名',
  `LOGIN` int(10) NOT NULL default '0' COMMENT '是否为登录状态',
  `AGE` bigint(20) NOT NULL default '0' COMMENT '年龄',
  `SEX` varchar(2) NOT NULL default 'n' COMMENT '性别',
  `TELEPHONE` bigint(20) NOT NULL default '0' COMMENT '电话号码',
  `ORDINARY_OR_SPECIAL` int(10) NOT NULL default '0' COMMENT '是否为估价师',
  `DRIVER_LICENSE` varchar(2) NOT NULL default 'n' COMMENT '是否有驾照',
  `INSURANCE` int(2) NOT NULL default 0 COMMENT '是否买保险',
  `PREMIUM` bigint(20)  default 0 COMMENT '保险金额'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
DROP TABLE IF EXISTS `PERSONAL_PICTURE`;
DROP TABLE IF EXISTS `PRICE_LIST`;
CREATE TABLE `PRICE_LIST` (
  `VEHICLE_TYPE` varchar(50) default null COMMENT '车型',
  `ORIGINAL_PRICE` bigint(50) default 0 COMMENT '出厂原价',
  `ANNUAL_LOSS` bigint(50) default 0 COMMENT '年损量',
  `SCRATGH_LOSS` bigint(50) default 0 COMMENT '刮擦受损量',
  `SUNKEN_LOSS` bigint(50) default 0 COMMENT '凹陷受损量',
  `CRACK_LOSS` bigint(50) default 0 COMMENT '开裂受损量',
  `FOLD_LOSS` bigint(50) default 0 COMMENT '褶皱受损量',
  `PERFORATION_LOSS` bigint(50) default 0 COMMENT '穿孔受损量'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='价目表';
DROP TABLE IF EXISTS `ORDER_LIST`;
CREATE TABLE `ORDER_LIST` (
  `ID` varchar(100) NOT NULL COMMENT '订单id',
  `EVA_ID` bigint(20) default 0 COMMENT '估价师用户id',
  `EVA_NAME`varchar(20) default null COMMENT '估价师用户名',
  `ORDINARY_ID` bigint(20) default 0 COMMENT '普通用户id',
  `ORD_NAME`varchar(20) default null COMMENT '普通用户用户名',
  `USER_IDENTIFICATION` bigint(20) default 0 COMMENT '估价师是否已经评估完成评估字段',
  `CAR_TYPE`varchar(20) default null COMMENT '车型',
  `CAR_COLOR`varchar(20) default null COMMENT '车辆颜色',
  `CAR_YEAR`varchar(20) default null COMMENT '车辆生产年份',
  `DANGE_POSITION`varchar(100) default null COMMENT '受损部位',
  `DANGE_TYPE`varchar(100) default null COMMENT '受损类型',
  `DANGE_PERCENT`varchar(100) default null COMMENT '受损百分比',
  `CAR_LOSS` varchar(50) default 0 COMMENT '车损价格',
  `CAR_VALUE` varchar(50) default 0 COMMENT '车辆价值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';
DROP TABLE IF EXISTS `VALUATION_LIST`;
CREATE TABLE `VALUATION_LIST` (
  `EVA_ID` bigint(50) NOT NULL default 0 COMMENT '估价师id',
  `USER_NAME`varchar(20) NOT NULL COMMENT '估价师用户名',
  `ORDINARY_ID` bigint(50) default 0 COMMENT '普通用户id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='估价师表';
DROP TABLE IF EXISTS `DRIVER_LICENSE`;
CREATE TABLE `DRIVER_LICENSE` (
  `ID` bigint(20) NOT NULL COMMENT '用户id',
  `CARD_ID`varchar(50) default NULL COMMENT '证号',
  `TIME`varchar(20) default NULL COMMENT '有效期限',
  `TYPE`varchar(20) default NULL COMMENT '证件类型',
  `BEGIN_TIME`varchar(20) default NULL COMMENT '有效起始日期',
  `ADDRESS`varchar(100) default NULL COMMENT '住址',
  `NAME`varchar(20) default NULL COMMENT '姓名',
  `COUNTRY`varchar(20) default NULL COMMENT '国籍',
  `BIRTH`varchar(20) default NULL COMMENT '出生日期',
  `SEX`varchar(20) default NULL COMMENT '性别',
  `CERTIFICATION_TIME`varchar(20) default NULL COMMENT '初次领证日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='驾驶证信息-表';