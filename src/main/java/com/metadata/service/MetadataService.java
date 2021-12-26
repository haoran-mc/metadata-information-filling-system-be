package com.metadata.service;

import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;

import java.util.List;

public interface MetadataService {
    /**
     * 获取所有批次service
     * @return batch对象集
     */
    List<Batch> getAllBatches();

    void insertSpecialData(Project project, Textbook textbook, Batch batch);

}
