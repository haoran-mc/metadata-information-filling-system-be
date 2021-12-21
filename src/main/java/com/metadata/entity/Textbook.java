package com.metadata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Textbook {
    int id;
    String name;
    String phone; // 填报人的电话
    String editor; // 主编
    String publishing_house; // 出版社
    Data publishing_time; // 出版时间
    Data selection_time; // 入选时间
    String attachment_path; // 附件路径
    int year;
    int batch;
}
