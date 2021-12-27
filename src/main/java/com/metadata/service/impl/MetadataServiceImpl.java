package com.metadata.service.impl;

import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Sp;
import com.metadata.entity.Textbook;
import com.metadata.mapper.BatchMapper;
import com.metadata.mapper.MetadataMapper;
import com.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetadataServiceImpl implements MetadataService {
    @Autowired
    MetadataMapper metadataMapper;

    @Autowired
    BatchMapper batchMapper;

    /**
     * 获取所有批次
     * @return batch对象集
     */
    @Override
    public List<Batch> getAllBatches() {
        return metadataMapper.getAllBatches();
    }

    /**
     * 插入特殊数据
     * @param project 插入项目特殊数据
     * @param textbook 插入教材特殊数据
     * @param batch 插入批次
     */
    @Override
    public void insertSpecialData(Project project, Textbook textbook, Batch batch) {
        if (project != null) {    // 这里也许需要改，可能出现project/textbook数据为{}的情况，不一定{}这种数据就是null，否则会多插入数据库很多空记录
            batchMapper.addProject(project);
        }
        if (textbook != null) {
            batchMapper.addTextbook(textbook);
        }
        metadataMapper.addBatch(batch);
        //插入sp表
        Sp sp = new Sp();
        sp.setYear(batch.getYear()); //获取新建批次year
        sp.setBatch_idx(batch.getBatch_idx()); //获取新建批次batch
        sp.setProject_id(metadataMapper.getSpProjectId()); //获取新插入project表的特殊数据的id
        sp.setTextbook_id(metadataMapper.getSpTextbookId());//获取新插入textbook表的特殊数据的id
        metadataMapper.addSp(sp);
    }
}