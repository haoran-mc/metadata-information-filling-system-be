package com.metadata.controller;

import com.metadata.common.lang.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("projects")
public class ProjectController {
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
