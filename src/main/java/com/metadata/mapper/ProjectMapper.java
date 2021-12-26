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
     * @param batch_idx 批次
     * @param name 名称
     * @return project对象集
     */
    List<Project> selectProjectByName(
            @Param("year") int year,
            @Param("batch_idx") int batch_idx,
            @Param("name") String name
    );

    /**
     * 删除指定id项目mapper
     * @param id 项目 id
     */
    void deleteProjectById(@Param("id") int id);

    /**
     * 更新指定id项目mapper
     * @param project project对象
     */
    void updateProject(@Param("project") Project project);
}
