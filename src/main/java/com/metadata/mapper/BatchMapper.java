package com.metadata.mapper;


import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BatchMapper {
    /**
     * 获取指定批次的项目mapper
     * @param year 年份
     * @param batch 批次
     * @return project对象集
     */
    List<Project> getBatchProject(
            @Param("year") int year,
            @Param("batch") int batch,
            @Param("page_num") int page_num,
            @Param("page_size") int page_size
    );

    /**
     * 获取指定批次的书籍mapper
     * @param year 年份
     * @param batch 批次
     * @return textbook对象集
     */
    List<Textbook> getBatchTextbook(
            @Param("year") int year,
            @Param("batch") int batch,
            @Param("page_num") int page_num,
            @Param("page_size") int page_size
    );

    /**
     * 插入新项目mapper
     * @param project project对象
     */
    void addProject(@Param("project") Project project);

    /**
     * 插入新书籍mapper
     * @param textbook textbook对象
     */
    void addTextbook(@Param("textbook") Textbook textbook);
}
