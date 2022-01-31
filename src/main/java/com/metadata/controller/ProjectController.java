package com.metadata.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.metadata.common.lang.Result;
import com.metadata.entity.Project;
import com.metadata.service.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;

    /**
     * 获取指定名称项目
     * @param year 年份
     * @param batchIdx 批次
     * @param name 名称
     * @return project对象集
     */
    @GetMapping("projects/{year}/{batch_idx}")
    public Result selectProjectByName(
            @PathVariable(name = "year") int year,
            @PathVariable(name = "batch_idx") int batchIdx,
            @RequestParam(name = "project_name") String name) {
        List<Project> projectList = projectService.selectProjectByName(year, batchIdx, name);
        return Result.success(projectList);
    }

    /**
     * 删除指定id项目
     * @param id 项目 id
     * @return null
     */
    @DeleteMapping("project")
    @SaCheckLogin
    @SaCheckRole(value = {"admin", "super_admin"}, mode = SaMode.OR)
    public Result deleteProjectById(@RequestParam(name = "id") int id) {
        projectService.deleteProjectById(id);
        return Result.success(null);
    }

    /**
     * 更新指定id项目
     * @param project project对象
     * @return null
     */
    @PutMapping("project")
    @SaCheckRole(value = {"admin", "super_admin"}, mode = SaMode.OR)
    public Result updateProjectById(@RequestBody Project project) {
        projectService.updateProject(project);
        return Result.success(null);
    }
}
