package com.metadata.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Batch {
    int id;
    int year;
    String name;
    int batchIdx;

    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    Date endTime;
}
