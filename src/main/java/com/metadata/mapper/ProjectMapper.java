package com.metadata.mapper;

import com.metadata.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ProjectMapper {

    /**
     * 获取指定名称项目mapper
     * @param year 年份
     * @param batch 批次
     * @param name 名称
     * @return project对象集
     */
    List<Project> selectProject(int year, int batch, String name);

    /**
     * 删除指定id项目mapper
     * @param project project对象
     */
    void deleteProject(@Param("project") Project project);

    /**
     * 更新指定id项目mapper
     * @param project project对象
     */
    void updateProject(@Param("project") Project project);
}
