package com.metadata.controller;

import com.metadata.common.lang.Result;
import com.metadata.entity.Batch;
import com.metadata.service.BatchService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("metadatas")
public class MetadataController {
    @Autowired
    BatchService batchService;

    @PostMapping
    public Result generateBatch() {
        return null;
    }

    /**
     * 获取所有批次
     * @return 所有批次列表
     */
    @GetMapping
    public Result getAllBatches() {
        List<Batch> data = batchService.getAllBatches();
        return Result.success(data);
    }
}
