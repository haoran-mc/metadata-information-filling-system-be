package com.metadata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sp {
    int id;
    int year;
    int batchIdx;
    int projectId;
    int textbookId;
}
