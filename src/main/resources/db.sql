DROP database IF EXISTS metadata;

CREATE database metadata;

use metadata;

create table metadata.batch
(
    id         int auto_increment comment 'id'
        primary key,
    year       int         null comment '这个批次所属的年份',
    batch_idx  int         null comment '这个批次在当年是第几批',
    name       varchar(30) null comment '批次名：第四次本科评估',
    end_time   date        null comment '这个批次截止填报的时间',
    start_time date        null,
    constraint batch_id_uindex
        unique (id)
);

create table metadata.project
(
    id                    int auto_increment comment 'id'
        primary key,
    name                  varchar(150) null comment '项目名称',
    host                  varchar(30)  null comment '主持人',
    preparer              varchar(30)  null comment '填表人的用户名，也就是电话',
    category_first_level  varchar(90)  null comment '国家级',
    category_second_level varchar(90)  null comment '科技部',
    category_third_level  varchar(90)  null comment '待补充......',
    department            varchar(150) null comment '项目单位，计算机研究中心',
    money                 int          null comment '项目经费',
    start_time            date         null comment '项目开始时间',
    end_time              date         null comment '项目结束时间',
    number                varchar(30)  null comment '编号：XF89FF232',
    attachment_path       varchar(30)  null comment '附件路径',
    year                  int          null comment '项目所属的年份',
    batch_idx             int          null comment '项目所属的批次',
    expand                varchar(600) null comment '扩充表',
    constraint project_id_uindex
        unique (id)
);

create table metadata.sp
(
    id          int auto_increment comment 'id'
        primary key,
    year        int null comment '年份',
    batch_idx   int null comment '批次',
    project_id  int null comment 'project_id',
    textbook_id int null comment 'textbook_id',
    constraint sp_id_uindex
        unique (id)
);

create table metadata.textbook
(
    id               int auto_increment comment 'id',
    name             varchar(150) null comment '教材名',
    preparer         varchar(30)  null comment '填表人的用户名，也就是电话号码',
    editor           varchar(30)  null comment '主编',
    publishing_house varchar(150) null comment '出版社',
    publishing_time  date         null comment '出版时间',
    selection_time   date         null comment '入选时间',
    attachment_path  varchar(30)  null comment '附件路径',
    year             int          null comment '教材所属年份',
    batch_idx        int          null comment '教材所属批次',
    expand           varchar(600) null,
    constraint id
        unique (id),
    constraint textbook_id_uindex
        unique (id)
);

create table metadata.user
(
    id       int auto_increment comment '主键'
        primary key,
    phone    varchar(30)                not null comment '用户手机号码',
    username varchar(30)                null comment '用户名',
    password varchar(100)               null comment '用户密码',
    role     varchar(30) default 'user' null comment '用户身份',
    image    varchar(30)                null comment '用户头像',
    constraint user_id_uindex
        unique (id)
);

