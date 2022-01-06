package com.metadata.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Textbook {
    int id;
    String name;
    String preparer; // 填报人的电话
    String editor; // 主编
    String publishingHouse; // 出版社

    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    Date publishingTime; // 出版时间
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    Date selectionTime; // 入选时间

    String attachmentPath; // 附件路径
    int year;
    int batchIdx;

    String expand;
}
