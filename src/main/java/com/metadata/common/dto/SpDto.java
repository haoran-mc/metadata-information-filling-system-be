package com.metadata.common.dto;

import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import lombok.Data;

@Data
public class SpDto {
    Project project;
    Textbook textbook;
}
