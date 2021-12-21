package com.metadata.controller;

import com.metadata.common.lang.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("metadatas")
public class MetadataController {
    @PostMapping
    public Result generateBatch() {
        return null;
    }

    @GetMapping
    public Result getAllBatches() {
        return null;
    }
}
