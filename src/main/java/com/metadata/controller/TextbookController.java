package com.metadata.controller;

import com.metadata.common.lang.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("metadatas")
public class TextbookController {
    @GetMapping
    public Result selectProjectByProjectName() {
        return null;
    }

    @DeleteMapping
    public Result deleteProjectById() {
        return null;
    }

    @PutMapping
    public Result editProjectById() {
        return null;
    }
}
