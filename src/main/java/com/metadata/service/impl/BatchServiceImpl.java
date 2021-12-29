package com.metadata.service.impl;

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
     * 获取指定批次的项目impl
     *
     * @param year      年份
     * @param batch     批次
     * @param page_num  页码
     * @param page_size 分页尺寸
     * @return project对象集
     */
    @Override
    public List<Project> getBatchProject(int year, int batch, int page_num, int page_size) {
        return batchMapper.getBatchProject(year, batch, page_num, page_size);
    }

    /**
     * 获取指定批次的书籍impl
     *
     * @param year      年份
     * @param batch     批次
     * @param page_num  页码
     * @param page_size 分页尺寸
     * @return textbook对象集
     */
    @Override
    public List<Textbook> getBatchTextbook(int year, int batch, int page_num, int page_size) {
        return batchMapper.getBatchTextbook(year, batch, page_num, page_size);
    }

    /**
     * 插入新的填报impl
     *
     * @param project  project对象
     * @param textbook textbook对象
     */
    @Override
    public void addFilling(Project project, Textbook textbook) {
        if (project != null) {
            batchMapper.addProject(project);
        }
        if (textbook != null) {
            batchMapper.addTextbook(textbook);
        }
    }
}
