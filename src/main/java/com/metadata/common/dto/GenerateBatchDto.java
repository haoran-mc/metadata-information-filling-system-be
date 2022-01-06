package com.metadata.common.dto;

import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import lombok.Data;

import java.util.List;

@Data
public class GenerateBatchDto {
    Batch batch;
    Project project;
    Textbook textbook;
    Boolean hasProject;
    Boolean hasTextbook;
    List<String> projectExpand;
    List<String> textbookExpand;
}
