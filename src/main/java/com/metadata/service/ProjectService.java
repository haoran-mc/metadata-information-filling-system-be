package com.metadata.service;

import com.metadata.entity.Project;

import java.util.List;

public interface ProjectService {

    /**
     * 获取指定名称项目service
     * @param year 年份
     * @param batch_idx 批次
     * @param name 名称
     * @return project对象集
     */
    List<Project> selectProject(int year, int batch, String name);

    /**
     * 删除指定id项目service
     * @param id 项目 id
     */
    void deleteProject(Project project);

    /**
     * 更新指定id项目service
     * @param project project对象
     */
    void updateProject(Project project);
}
