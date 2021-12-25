package com.metadata.mapper;

import com.metadata.entity.Batch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MetadataMapper {

    /**
     * 获取所有批次mapper
     * @return batch对象集
     */
    List<Batch> getAllBatches();
}
