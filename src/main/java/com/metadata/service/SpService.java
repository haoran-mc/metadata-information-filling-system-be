package com.metadata.service;

import com.metadata.entity.Sp;

public interface SpService {
    void insertSpecialData(Boolean hasProject,
                           Project project,
                           Boolean hasTextbook,
                           Textbook textbook,
                           Batch batch);

    Sp getSpByYearBatchIdx(int year, int batch);
}
