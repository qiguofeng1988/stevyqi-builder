CREATE SCHEMA `stevyqi` DEFAULT CHARACTER SET utf8 ;

create table stevyqi.stevyqi_demo(
	id bigint(20) not null auto_increment comment 'id',
	demo_varchar varchar(255) comment '文本',
	demo_int int comment '整型',
	demo_bigint bigint comment '长整型',
	demo_decimal decimal(20,2) comment '小数',
	demo_datetime datetime comment '时间',
	demo_text text comment '长文本',
	deleted int(1) default 0 comment '删除状态：0，未删除；1，已删除',
	create_time datetime comment '创建时间',
	create_by bigint(20) comment '创建人',
	update_time datetime comment '更新时间',
	update_by bigint(20) comment '更新人',
	primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '示例表';