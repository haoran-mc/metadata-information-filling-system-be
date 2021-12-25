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
     * @param batch 批次
     * @param name 名称
     * @return project对象集
     */
    @GetMapping
    public Result selectProjectByProjectName(@RequestParam(name = "year") int year, @RequestParam(name = "batchid") int batch,
                                             @RequestParam(name = "projectName") String name) {
        List<Project> pj = projectService.selectProject(year, batch, name);
        return Result.success(pj);
    }

    /**
     * 删除指定id项目
     * @param project project对象
     * @return null
     */
    @DeleteMapping
    public Result deleteProjectById(@RequestBody Project project) {
        projectService.deleteProject(project);
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
