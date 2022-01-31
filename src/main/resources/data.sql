-- batch
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (1,  2017, 1, '2017年第一轮本科评估', '2017-04-04 08:00:00', '2017-05-08 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (2,  2017, 2, '2017年第二轮本科评估', '2017-05-10 08:00:00', '2017-08-21 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (3,  2017, 3, '2017年一流本科评估',   '2017-08-23 08:00:00', '2017-09-10 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (4,  2017, 4, '2017年第三轮本科评估', '2017-09-08 08:00:00', '2017-11-02 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (5,  2017, 5, '2017年第四轮本科评估', '2017-10-14 08:00:00', '2017-11-23 08:00:00');

-- project
insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (1, '1', '1', '1', '1', '1', 1, '1', 1, '2021-12-14', '2021-12-14', '1', '1', 1, 1);
insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (2, '南昌都市旅游生态文明建设研究', '俞海滨', '俞海滨', '国家级', '国家社科基金项目', null, '南昌市人民政府发展研究中心', 42000, '2017-02-12', '2017-08-22', 'Z-E06-B', null, 2017, 1);
insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (3, '跨国公司R&D中心集聚的知识辐射与倍增效应研究', '许学国', '许学国', '国家级', '国家自然基金项目', null, '教育部社会科学司', 22000, '2017-03-12', '2017-09-19', '13YJC630023', null, 2017, 1);
insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (4, 'V2G模式下适应随机环境的EV能量最优均衡调控策略与方法研究', '丁雪枫', '丁雪枫', '国家级', '科技部项目', null, '教育部社会科学司', 29000, '2017-08-07', '2017-11-26', '13YJC790022', null, 2017, 1);

insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (5, '1', '1', '1', '1', '1', 1, '1', 1, '2021-12-14', '2021-12-14', '1', null, 2017, 2);
insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (6, '重点区域交通污染治理的合作机制研究—以长三角地区为例', '李常敏', '李常敏', '国防/军队重要科研项目', null, null, '教育部社会科学司', 28000, '2017-02-18', '2017-12-01', '13YJC790022', null, 2017, 2);
insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (7, '数据挖掘与实证研究', '杜颖洁', '杜颖洁', '省级项目', '省科技厅立项', null, '教育部社会科学司', 13000, '2017-02-31', '2017-06-03', '13YJC790022', null, 2017, 2);

insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (8, '1', '1', '1', '1', '1', 1, '1', null, '2021-12-14', '2021-12-14', '1', null, 2017, 3);
insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (9, '全国哲学社会科学规划办公室', '周建', '周建', '省级项目', '省自然科学基金', null, '管科系', null, '2017-09-11', '2017-10-23', '13CGL057', null, 2017, 3);

insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (10, '1', '1', '1', '1', '1', 1, '1', null, '2021-12-14', '2021-12-14', '1', null, 2017, 4);
insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (11, '基于网络嵌入和知识嵌入的我国产学研协同创新网络的形成机制、演化路径与扶持对策研究', '王海花', '王海花', '国家级', '科技部项目', null, '全国哲学社会科学规划办公室', null, '2017-01-10', '2017-11-18', '13CGL014', null, 2017, 4);

insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (12, '1', '1', '1', '1', '1', 1, '1', 1, '2021-12-14', '2021-12-14', null, null, 2017, 5);
insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (13, '高新技术产业集群政策有效性评价体系的构建和应用', '于丽英', '于丽英', '境外合作科研项目', null, null, '南昌市科学技术委员会', 29000, '2017-04-24', '2017-09-21', null, null, 2017, 5);
insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (14, '国际大都市地下轨道交通客流监测及突发事件应急管理方案研究', '邹宗峰', '邹宗峰', '省级项目', '省教育厅科研立项', null, '南昌市科学技术委员会', 11000, '2017-08-11', '2017-12-08', null, null, 2017, 5);

-- textbook
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (1, '1', '1', '1', '1', '2021-12-14', '2021-12-26', '1', 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (2, '工程图学', '郭纪林', '郭纪林', '北京理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (3, '工程图学习题集', '郭纪林', '郭纪林', '人民邮电出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (4, '公差配合与技术测量（第2版）', '胡瑢华', '胡瑢华', '清华大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (5, '机械基础实验教程', '刘莹', '刘莹', '北京理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (6, '机械设计课程设计', '刘莹', '刘莹', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (7, '机械制图（第三版）', '郭纪林', '郭纪林', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (8, '机械制图（第四版）', '郭纪林', '郭纪林', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (9, '机械制图习题集（第三版）', '郭纪林', '郭纪林', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (10, '机械制图习题集（第四版）', '郭纪林', '郭纪林', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (11, '机械制图习题集（应用本科）', '郭纪林', '郭纪林', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (12, '机械制造工程英语', '饶锡新', '饶锡新', '华中科技大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (13, '机械制造实训教程', '罗丽萍', '罗丽萍', '河南科学技术出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (14, '机械制造自学考试指导', '郭纪林', '郭纪林', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (15, '自动控制系统及应用', '刘玲腾', '刘玲腾', '清华大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (16, '自动控制原理与应用', '刘玲腾', '刘玲腾', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (17, 'AutoCAD 2006中文版实用教程', '郭纪林', '郭纪林', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (18, 'AutoCAD 2006中文版习题集', '郭纪林', '郭纪林', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (19, 'AutoCAD2008基础教程', '郭纪林', '郭纪林', '大连理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (20, 'Pro/ENGINEEG基础教程', '郭纪林', '郭纪林', '人民邮电出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (21, '防火墙技术标准教程', '曾勍炜', '曾勍炜', '北京理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (22, '面向对象方法工程实训', '刘晓强', '刘晓强', '中国科技大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (23, '软件工程实训套件教学系列教材', '曾勍炜', '曾勍炜', '北京理工大学出版社', '2021-12-14', '2021-12-26', null, 2017, 1);

insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (24, '1', '1', '1', '1', '2021-12-14', null, null, 2017, 2);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (25, '移动软件技术工程实训教程', '李建民', '李建民', '中国商业出版社', '2021-12-14', '2021-12-26', null, 2017, 2);

insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (26, '1', '1', '1', '1', '2021-12-14', null, null, 2017, 3);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (27, '软件工程实训套件教学系列教材—Web工程实训教程', '李建民', '李建民', '中国商业出版社', '2021-12-14', '2021-12-26', null, 2017, 3);

insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (28, '1', '1', '1', '1', '2021-12-14', null, null, 2017, 5);
insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
values (29, '网络综合布线技术与工程实训教材', '孙丽华', '孙丽华', '电子工业出版社', '2021-12-14', '2021-12-26', null, 2017, 5);

-- sp
insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (1, 2017, 1, 1, 1);
insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (2, 2017, 2, 5, 24);
insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (3, 2017, 3, 8, 26);
insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (4, 2017, 4, 10, null);
insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (5, 2017, 5, 12, 28);

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (6,  2018, 1, '2017年第一轮本科评估', '2017-02-06 08:00:00', '2017-03-30 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (7,  2018, 2, '2017年第二轮本科评估', '2017-03-29 08:00:00', '2017-04-17 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (8,  2018, 3, '2017年第三轮本科评估', '2017-08-12 08:00:00', '2017-09-01 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (9,  2018, 4, '2017年一流本科评估',   '2017-09-20 08:00:00', '2017-10-23 08:00:00');

insert into metadata.project (id, name, host, username, category_first_level, category_second_level, category_third_level, department, money, start_time, end_time, number, attachment_path, year, batch)
values (1, '1', '1', '1', '1', '1', 1, '1', 1, '2021-12-14', '2021-12-14', '1', '1', 1, 1);

-- insert into metadata.textbook (id, name, editor, username, publishing_house, publishing_time, selection_time, attachment_path, year, batch)
-- values (1, '1', '1', '1', );

-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (6, 2018, 1, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (7, 2018, 2, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (8, 2018, 3, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (9, 2018, 4, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (10, 2018, 5, , );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (10, 2019, 1, '2017年一流本科评估',   '2017-01-31 08:00:00', '2017-08-28 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (11, 2019, 2, '2017年第一轮本科评估', '2017-03-21 08:00:00', '2017-04-02 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (12, 2019, 3, '2017年第二轮本科评估', '2017-06-07 08:00:00', '2017-07-17 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (13, 2019, 4, '2017年第三轮本科评估', '2017-07-05 08:00:00', '2017-08-08 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (14, 2019, 5, '2017年第四轮本科评估', '2017-07-12 08:00:00', '2017-08-22 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (15, 2019, 6, '2017年第五轮本科评估', '2017-11-19 08:00:00', '2017-12-29 08:00:00');

-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (11, 2019, 1, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (12, 2019, 2, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (13, 2019, 3, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (14, 2019, 4, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (15, 2019, 5, , );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (16, 2020, 1, '2017年第一轮本科评估', '2017-10-18 08:00:00', '2017-11-13 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (17, 2020, 2, '2017年第二轮本科评估', '2017-10-22 08:00:00', '2017-11-07 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (18, 2020, 3, '2017年第三轮本科评估', '2017-11-03 08:00:00', '2017-11-29 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (19, 2020, 4, '2017年第四轮本科评估', '2017-12-11 08:00:00', '2017-12-30 08:00:00');

-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (16, 2020, 1, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (17, 2020, 2, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (18, 2020, 3, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (19, 2020, 4, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (20, 2020, 5, , );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (20, 2021, 1, '2017年第一轮本科评估', '2017-01-19 08:00:00', '2017-02-06 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (21, 2021, 2, '2017年第二轮本科评估', '2017-03-22 08:00:00', '2017-04-27 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (22, 2021, 3, '2017年一流本科评估',   '2017-05-30 08:00:00', '2017-07-28 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (23, 2021, 4, '2017年第三轮本科评估', '2017-07-01 08:00:00', '2017-12-12 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (24, 2021, 5, '2017年第四轮本科评估', '2017-10-04 08:00:00', '2017-11-16 08:00:00');
insert into metadata.batch (id, year, batch_idx, batch_name, start_time, end_time) values (25, 2021, 6, '2017年第五轮本科评估', '2017-11-27 08:00:00', '2017-12-28 08:00:00');

-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (21, 2021, 1, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (22, 2021, 2, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (23, 2021, 3, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (24, 2021, 4, , );
-- insert into metadata.sp (id, year, batch_idx, project_id, textbook_id) values (25, 2021, 5, , );