package com.metadata.mapper;


import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BatchMapper {
    /**
     * 主页获取所有批次
     * @return 批次列表
     */
    List<Batch> getAllBatches();

    void addBatch(@Param("batch") Batch batch);

    /**
     * 获取指定批次的项目mapper
     * @param year 年份
     * @param batchIdx 批次
     * @return project对象集
     */
    List<Project> getBatchProject(
            @Param("year") int year,
            @Param("batchIdx") int batchIdx,
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize
    );

    /**
     * 获取指定批次的书籍mapper
     * @param year 年份
     * @param batchIdx 批次
     * @return textbook对象集
     */
    List<Textbook> getBatchTextbook(
            @Param("year") int year,
            @Param("batchIdx") int batchIdx,
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize
    );

    int getMaxIdxByYear(@Param("year") int year);
}
