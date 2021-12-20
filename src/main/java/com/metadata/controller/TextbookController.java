package com.metadata.controller;

import com.metadata.common.lang.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("textbooks")
public class TextbookController {
    @GetMapping("select")
    public Result selectTextbook() {
        return null;
    }

    @PostMapping("add")
    public Result addTextbook() {
        return null;
    }

    @PutMapping("update")
    public Result updateTextbook() {
        return null;
    }

    @DeleteMapping("delete")
    public Result deleteTextbook() {
        return null;
    }
}
