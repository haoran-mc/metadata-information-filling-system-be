package com.metadata.service;

import com.metadata.entity.Project;
import com.metadata.entity.Textbook;

import java.util.List;

public interface BatchService {
    /**
     * 获取指定批次的项目service
     * @param year 年份
     * @param batch 批次
     * @param category 种类
     * @return project对象集
     */
    List<Project> getBatchProject(int year, int batch, int category);

    /**
     * 获取指定批次的书籍service
     * @param year 年份
     * @param batch 批次
     * @param category 种类
     * @return textbook对象集
     */
    List<Textbook> getBatchTextbook(int year, int batch, int category);

    /**
     * 插入新的填报service
     * @param project project对象
     * @param textbook textbook对象
     */
    void createFilling(Project project, Textbook textbook);
}
