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
    public Sp getSpByYearBatchIdx(int year, int batch) {
        return spMapper.getSpByYearBatchIdx(year, batch);
    }
}
