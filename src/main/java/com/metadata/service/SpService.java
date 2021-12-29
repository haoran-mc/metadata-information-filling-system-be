package com.metadata.service;

import com.metadata.entity.Sp;

public interface SpService {
    Sp getSpByYearBatchIdx(int year, int batch);
}
