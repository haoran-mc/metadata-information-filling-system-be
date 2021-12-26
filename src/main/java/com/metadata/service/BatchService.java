package com.metadata.service;

import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;

import java.util.List;

public interface BatchService {

    /**
     * 获取所有批次
     * @return 所有批次列表
     */
    List<Batch> getAllBatches();

    /**
     * 获取选定批次的项目
     * @param year 年份
     * @param batch 批次
     * @param page_num 页码
     * @param page_size 分页尺寸
     * @return 项目列表
     */
    List<Project> getBatchProject(int year, int batch, int page_num, int page_size);

    /**
     * 获取选定批次的书籍
     * @param year 年份
     * @param batch 批次
     * @param page_num 页码
     * @param page_size 分页尺寸
     * @return 书籍列表
     */
    List<Textbook> getBatchTextbook(int year, int batch, int page_num, int page_size);

    /**
     * 用户填报
     * @param project project对象
     * @param textbook textbook对象
     */
    void createFilling(Project project, Textbook textbook);
}
