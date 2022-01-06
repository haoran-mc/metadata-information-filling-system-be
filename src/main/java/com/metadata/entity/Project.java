package com.metadata.entity;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    String preparer; // 填表人的电话

    String categoryFirstLevel;
    String categorySecondLevel;
    String categoryThirdLevel;

    String department; // 立项单位，计算机中心
    int money; // 经费
    String number; // 编号，XF89FF233

    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    Date startTime; // 项目开始时间
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    Date endTime; // 项目截至时间

    String attachmentPath; // 附件地址
    int year;
    int batchIdx;

    String expand;
}
