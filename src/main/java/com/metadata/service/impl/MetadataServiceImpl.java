package com.metadata.service.impl;

import com.metadata.entity.Batch;
import com.metadata.mapper.MetadataMapper;
import com.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("metadataService")
public class MetadataServiceImpl implements MetadataService {
    @Autowired
    MetadataMapper metadataMapper;

    /**
     * 获取所有批次impl
     * @return batch对象集
     */
    @Override
    public List<Batch> getAllBatches() {
        return metadataMapper.getAllBatches();
    }

}
