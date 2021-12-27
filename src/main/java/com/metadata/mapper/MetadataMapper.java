package com.metadata.mapper;

import com.metadata.entity.Batch;
import com.metadata.entity.Sp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MetadataMapper {
    /**
     * 主页获取所有批次
     * @return 批次列表
     */
    List<Batch> getAllBatches();

    /**
     * 插入新的batch记录mapper
     * @param batch batch对象
     */
    void addBatch(@Param("batch") Batch batch);

    /**
     * 插入新的sp记录
     * @param sp sp对象
     */
    void addSp(@Param("sp") Sp sp);

    /**
     * 获取特殊项目 id
     * @return 项目
     */
    int getSpProjectId();

    /**
     * 获取特殊教材 id
     * @return 教材
     */
    int getSpTextbookId();
}
