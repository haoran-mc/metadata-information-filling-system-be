package com.metadata.service.impl;

import cn.hutool.json.JSONUtil;
import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Sp;
import com.metadata.entity.Textbook;
import com.metadata.mapper.BatchMapper;
import com.metadata.mapper.ProjectMapper;
import com.metadata.mapper.SpMapper;
import com.metadata.mapper.TextbookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class SpServiceImpl implements com.metadata.service.SpService {
    @Autowired
    SpMapper spMapper;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    TextbookMapper textbookMapper;

    @Autowired
    BatchMapper batchMapper;

    @Override
    public void insertSpecialData(Boolean hasProject,
                                  Project project,
                                  Boolean hasTextbook,
                                  Textbook textbook,
                                  Batch batch) {
        int batchIdx = batchMapper.getMaxIdxByYear(batch.getYear());
        batch.setBatchIdx(batchIdx + 1);

        Date timeNow = new Date();
        /*
         *  Calendar cal = Calendar.getInstance();
         *  cal.setTime(timeNow); // 设置当前时间
         *  SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd"); // 设置格式
         *  String startTime = ft.format(cal.getTime());
         */
        batch.setStartTime(timeNow);

        batchMapper.addBatch(batch);
        // sp 表
        Sp sp = new Sp();
        sp.setYear(batch.getYear());
        sp.setBatchIdx(batch.getBatchIdx());
        sp.setProjectId(0);
        sp.setTextbookId(0);
        if (hasProject) {
            projectMapper.addProject(project);
            sp.setProjectId(projectMapper.getSpProjectId());
        }
        if (hasTextbook) {
            textbookMapper.addTextbook(textbook);
            sp.setTextbookId(textbookMapper.getSpTextbookId());
        }
        spMapper.addSp(sp);
    }

    @Override
    public Sp getSpByYearBatchIdx(int year, int batchIdx) {
        return spMapper.getSpByYearBatchIdx(year, batchIdx);
    }
}
