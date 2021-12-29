package com.metadata.controller;

import com.metadata.common.lang.Result;
import com.metadata.entity.Sp;
import com.metadata.service.SpService;
import com.metadata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sp")
public class SpController {
    @Autowired
    SpService spService;

    @GetMapping
    public Result getSpByYearBatchIdx(
            @RequestParam(name = "year") int year,
            @RequestParam(name = "batch_idx") int batch_idx) {
        Sp sp = spService.getSpByYearBatchIdx(year, batch_idx);
        return Result.success(sp);
    }
}

