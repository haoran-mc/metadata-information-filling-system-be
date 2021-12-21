package com.metadata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    int id;
    String name; // 项目名称
    String host; // 主持人
    String phone; // 填表人的电话

    String category_first_level;
    String category_second_level;
    String category_third_level;

    String department; // 立项单位，计算机中心
    int money; // 经费
    String number; // 编号，XF89FF233
    Date start_time; // 项目开始时间
    Date end_time; // 项目截至时间
    String attachment_path; // 附件地址
    int year;
    int batch;
}
