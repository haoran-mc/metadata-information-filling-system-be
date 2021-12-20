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
    int batch;
    int project_id;
    int textbook_id;
}
