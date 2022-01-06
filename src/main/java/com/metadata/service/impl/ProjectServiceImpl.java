package com.metadata.service.impl;

import com.metadata.entity.Project;
import com.metadata.mapper.ProjectMapper;
import com.metadata.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    /**
     * 获取指定名称项目impl
     * @param year 年份
     * @param batch_idx 批次
     * @param name 名称
     * @return project对象集
     */
    @Override
    public List<Project> selectProjectByName(int year, int batch_idx, String name) {
        List<Project> projectList = projectMapper.selectProjectByName(year, batch_idx, name);
        return projectList;
    }

    @Override
    public void addProject(Project project) {
        projectMapper.addProject(project);
    }

    /**
     * 删除指定id项目impl
     * @param id 项目 id
     */
    @Override
    public void deleteProjectById(int id) {
        projectMapper.deleteProjectById(id);
    }

    /**
     * 通过 sp 表中的 project_id 获取 project
     * @param id
     * @return
     */
    @Override
    public Project getProjectById(int id) {
        return projectMapper.getProjectById(id);
    }

    /**
     * 获取我的项目列表
     * @param hostname 主持人
     * @return 项目列表
     */
    public List<Project> getMyProjects(String hostname) {
        return projectMapper.getMyProjects(hostname);
    }

    /**
     * 更新指定id项目impl
     * @param project project对象
     */
    @Override
    public void updateProject(Project project) {
        projectMapper.updateProject(project);
    }
}
