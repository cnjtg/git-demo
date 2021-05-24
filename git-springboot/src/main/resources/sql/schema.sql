use db2020;

create table git_user(
    uuid varchar(36) primary key not null comment 'UUID',
    username varchar (50) comment '姓名',
    password varchar (34) comment '密码',
    address varchar(50) comment '地址'
)