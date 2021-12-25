package com.metadata.service;

import com.metadata.entity.Batch;

import java.util.List;

public interface MetadataService {
    /**
     * 获取所有批次service
     * @return batch对象集
     */
    List<Batch> getAllBatches();
}
