package com.metadata.controller;

import com.metadata.common.lang.Result;
import com.metadata.entity.Project;
import com.metadata.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    /**
     * 获取指定名称项目
     * @param year 年份
     * @param batch_idx 批次
     * @param name 名称
     * @return project对象集
     */
    @GetMapping
    public Result selectProjectByName(
            @RequestParam(name = "year") int year,
            @RequestParam(name = "batch_idx") int batch_idx,
            @RequestParam(name = "project_name") String name) {
        List<Project> projectList = projectService.selectProjectByName(year, batch_idx, name);
        return Result.success(projectList);
    }

    /**
     * 删除指定id项目
     * @param id 项目 id
     * @return null
     */
    @DeleteMapping
    public Result deleteProjectById(@RequestParam(name = "id") int id) {
        projectService.deleteProjectById(id);
        return Result.success(null);
    }

    /**
     * 更新指定id项目
     * @param project project对象
     * @return null
     */
    @PutMapping
    public Result editProjectById(@RequestBody Project project) {
        projectService.updateProject(project);
        return Result.success(null);
    }
}
