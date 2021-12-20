package com.metadata.controller;

import com.metadata.common.lang.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("batches")
public class BatchController {
    // 获取所有批次
    @GetMapping("all")
    public Result getAllBatches() {
        return null;
    }

    @GetMapping("year")
    public Result getAppointedBatch() {
        return null;
    }
}
