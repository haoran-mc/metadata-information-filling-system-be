package com.metadata.service;

import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;

import java.util.List;

public interface MetadataService {
    /**
     * 主页获取所有批次列表
     * @return 批次列表
     */
    List<Batch> getAllBatches();

    /**
     * 插入特殊数据
     * @param project 插入项目特殊数据
     * @param textbook 插入教材特殊数据
     * @param batch 插入批次
     */
    void insertSpecialData(Project project, Textbook textbook, Batch batch);
}
