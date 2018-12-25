DROP TABLE IF EXISTS cms_user;
CREATE TABLE user (
  id varchar(20) NOT NULL COMMENT '用户编号',
  name varchar(20) DEFAULT NULL COMMENT '姓名',
  password varchar(50) NOT NULL COMMENT '密码',
  telphone varchar(20) DEFAULT NULL COMMENT '手机号',
  email varchar(100) DEFAULT NULL COMMENT '邮箱',
  sex int(1) DEFAULT NULL COMMENT '性别 0：女 1：男',
  gmt_create datetime DEFAULT CURRENT_TIMESTAMP,
  gmt_modified datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';