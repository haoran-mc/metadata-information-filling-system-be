package com.metadata.service;

import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Sp;
import com.metadata.entity.Textbook;

public interface SpService {
    void insertSpecialData(Boolean hasProject,
                           Project project,
                           Boolean hasTextbook,
                           Textbook textbook,
                           Batch batch);

    Sp getSpByYearBatchIdx(int year, int batch);
}
