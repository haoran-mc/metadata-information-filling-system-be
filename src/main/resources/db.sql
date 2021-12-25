DROP database IF EXISTS metadata;

CREATE database metadata;

use metadata;

create table batch
(
    id         int auto_increment comment 'id'
        primary key,
    year       int         null comment '这个批次所属的年份',
    batch_idx  int         null comment '这个批次在当年是第几批',
    batch_name varchar(30) null comment '批次名：第四次本科评估',
    end_time   datetime    null comment '这个批次截止填报的时间',
    constraint batch_id_uindex
        unique (id)
);

create table project
(
    id                    int auto_increment comment 'id'
        primary key,
    name                  varchar(150) null comment '项目名称',
    host                  varchar(30)  null comment '主持人',
    username              varchar(30)  null comment '填表人的用户名，也就是电话',
    category_first_level  varchar(30)  null comment '国家级',
    category_second_level varchar(30)  null comment '科技部',
    category_third_level  varchar(30)  null comment '待补充......',
    department            varchar(150) null comment '项目单位，计算机研究中心',
    money                 int          null comment '项目经费',
    start_time            date         null comment '项目开始时间',
    end_time              date         null comment '项目结束时间',
    number                varchar(30)  null comment '编号：XF89FF232',
    attachment_path       varchar(30)  null comment '附件路径',
    year                  int          null comment '项目所属的年份',
    batch                 int          null comment '项目所属的批次',
    constraint project_id_uindex
        unique (id)
);

create table sp
(
    id          int auto_increment comment 'id'
        primary key,
    year        int null comment '年份',
    batch       int null comment '批次',
    project_id  int null comment 'project_id',
    textbook_id int null comment 'textbook_id',
    constraint sp_id_uindex
        unique (id)
);

create table textbook
(
    id               int auto_increment comment 'id'
        primary key,
    name             varchar(150) null comment '教材名',
    username         varchar(30)  null comment '填表人的用户名，也就是电话号码',
    editor           varchar(30)  null comment '主编',
    publishing_house varchar(150) null comment '出版社',
    poblishing_time  date         null comment '出版时间',
    selection_time   date         null comment '入选时间',
    attachment_path  varchar(30)  null comment '附件路径',
    year             int          null comment '教材所属年份',
    batch            int          null comment '教材所属批次',
    constraint textbook_id_uindex
        unique (id)
);

create table user
(
    id       int auto_increment comment '主键'
        primary key,
    phone    varchar(30)                not null,
    username varchar(30)                null,
    password varchar(30)                null,
    role     varchar(30) default 'user' null,
    constraint user_id_uindex
        unique (id)
);