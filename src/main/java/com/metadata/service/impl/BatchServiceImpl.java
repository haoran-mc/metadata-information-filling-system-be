package com.metadata.service.impl;

import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.mapper.BatchMapper;
import com.metadata.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    BatchMapper batchMapper;

    /**
     * 获取所有批次
     *
     * @return batch对象集
     */
    @Override
    public List<Batch> getAllBatches() {
        return batchMapper.getAllBatches();
    }

    /**
     * 获取指定批次的项目impl
     *
     * @param year     年份
     * @param batchIdx    批次
     * @param pageNum  页码
     * @param pageSize 分页尺寸
     * @return project对象集
     */
    @Override
    public List<Project> getBatchProject(int year, int batchIdx, int pageNum, int pageSize) {
        return batchMapper.getBatchProject(year, batchIdx, pageNum, pageSize);
    }

    /**
     * 获取指定批次的书籍impl
     *
     * @param year     年份
     * @param batchIdx    批次
     * @param pageNum  页码
     * @param pageSize 分页尺寸
     * @return textbook对象集
     */
    @Override
    public List<Textbook> getBatchTextbook(int year, int batchIdx, int pageNum, int pageSize) {
        return batchMapper.getBatchTextbook(year, batchIdx, pageNum, pageSize);
    }

    @Override
    public int getMaxIdxByYear(int year) {
        return batchMapper.getMaxIdxByYear(year);
    }
}
