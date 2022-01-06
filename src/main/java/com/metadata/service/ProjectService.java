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
    List<Project> selectProjectByName(int year, int batch_idx, String name);

    void addProject(Project project);

    /**
     * 删除指定id项目service
     * @param id 项目 id
     */
    void deleteProjectById(int id);

    /**
     * 通过 sp 表中的 project_id 获取 project
     * @param id
     * @return
     */
    Project getProjectById(int id);

    /**
     * 获取我的项目列表
     * @param hostname 主持人
     * @return 项目列表
     */
    List<Project> getMyProjects(String hostname);

    /**
     * 更新指定id项目service
     * @param project project对象
     */
    void updateProject(Project project);
}
