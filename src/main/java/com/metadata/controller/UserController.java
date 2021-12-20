package com.metadata.controller;

import com.metadata.common.lang.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping("select")
    public Result selectUser() {
        return null;
    }

    @PutMapping("update")
    public Result updateUser() {
        return null;
    }

    @GetMapping("batches")
    public Result getMyBatches() {
        return null;
    }

    @GetMapping("metadata")
    public Result getMyMetadata() {
        return null;
    }

    @PostMapping("newbatch")
    public Result newBatch() {
        return null;
    }
}
