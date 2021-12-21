package com.metadata.controller;

import com.metadata.common.lang.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("batches")
public class BatchController {
    @GetMapping
    // 获取所有批次
    public Result getBatch() {
        return null;
    }

    @PostMapping
    // 用户填报数据
    public Result addData() {
        return null;
    }
}
