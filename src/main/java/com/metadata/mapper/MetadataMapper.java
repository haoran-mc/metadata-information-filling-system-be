package com.metadata.mapper;

import com.metadata.entity.Batch;
import com.metadata.entity.Sp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MetadataMapper {

    /**
     * 获取所有批次mapper
     * @return batch对象集
     */
    List<Batch> getAllBatches();

    /**
     * 插入新的batch记录mapper
     * @param batch batch对象
     */
    void createBatch(@Param("batch") Batch batch);

    /**
     * 插入新的sp记录
     * @param sp sp对象
     */
    void createSp(@Param("sp") Sp sp);

    int getLatestProjectId();

    int getLatestTextbookId();
}
