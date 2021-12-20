package com.metadata.entity;

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
    int batch_idx;
    String batch_name;
    Date end_time;
}
