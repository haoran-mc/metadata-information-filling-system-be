package com.metadata.service;

import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;

import java.util.List;

public interface BatchService {
    /**
     * 主页获取所有批次列表
     * @return 批次列表
     */
    List<Batch> getAllBatches();

    /**
     * 获取选定批次的项目
     * @param year 年份
     * @param batchIdx 批次
     * @param pageNum 页码
     * @param pageSize 分页尺寸
     * @return 项目列表
     */
    List<Project> getBatchProject(int year, int batchIdx, int pageNum, int pageSize);

    /**
     * 获取选定批次的书籍
     * @param year 年份
     * @param batchIdx 批次
     * @param pageNum 页码
     * @param pageSize 分页尺寸
     * @return 书籍列表
     */
    List<Textbook> getBatchTextbook(int year, int batchIdx, int pageNum, int pageSize);

    int getMaxIdxByYear(int year);
}
