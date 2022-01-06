package com.metadata.mapper;

import com.metadata.entity.Sp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpMapper {
    Sp getSpByYearBatchIdx(@Param("year") int year, @Param("batchIdx") int batchIdx);

    void addSp(@Param("sp") Sp sp);
}
