package com.metadata.service.impl;

import com.metadata.entity.Sp;
import com.metadata.mapper.SpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpServiceImpl implements com.metadata.service.SpService {
    @Autowired
    SpMapper spMapper;

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
