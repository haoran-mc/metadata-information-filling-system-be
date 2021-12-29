package com.metadata.mapper;

import com.metadata.entity.Sp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpMapper {
    Sp getSpByYearBatchIdx(int year, int batch);
}
