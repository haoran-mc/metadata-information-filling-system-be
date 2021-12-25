package com.metadata.controller;

import cn.hutool.json.JSONObject;
import com.metadata.common.lang.Result;
import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("metadatas")
public class MetadataController {
    @Autowired
    MetadataService metadataService;

    @PostMapping
    public Result generateBatch(@RequestBody JSONObject jsonObject) {
        Project project = jsonObject.get("project", Project.class);
        Textbook textbook = jsonObject.get("textbook", Textbook.class);
        Batch batch = jsonObject.get("batch",Batch.class);
        metadataService.insertSpecialData(project, textbook, batch);
        return Result.success(null);
    }

    /**
     * 获取所有批次
     * @return batch对象集
     */
    @GetMapping
    public Result getAllBatches() {
        List<Batch> data = metadataService.getAllBatches();
        return Result.success(data);
    }

}
