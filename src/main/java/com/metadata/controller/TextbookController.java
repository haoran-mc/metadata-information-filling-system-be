package com.metadata.controller;

import com.metadata.common.lang.Result;
import com.metadata.entity.Textbook;
import com.metadata.service.TextbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("textbooks")
public class TextbookController {
    @Autowired
    TextbookService textbookService;

    /**
     * 获取指定名称书籍
     * @param year 年份
     * @param batch 批次
     * @param name 名称
     * @return textbook对象集
     */
    @GetMapping
    public Result selectProjectByProjectName(@RequestParam(name = "year") int year, @RequestParam(name = "batchid") int batch,
                                             @RequestParam(name = "textbookName") String name) {
        List<Textbook> tb = textbookService.selectTextbook(year, batch, name);
        return Result.success(tb);
    }

    /**
     * 删除指定id书籍
     * @param textbook textbook对象
     * @return null
     */
    @DeleteMapping
    public Result deleteProjectById(@RequestBody Textbook textbook) {
        textbookService.deleteTextbook(textbook);
        return Result.success(null);
    }

    /**
     * 更新指定id书籍
     * @param textbook textbook对象
     * @return null
     */
    @PutMapping
    public Result editProjectById(@RequestBody Textbook textbook) {
        textbookService.updateTextbook(textbook);
        return Result.success(null);
    }
}
