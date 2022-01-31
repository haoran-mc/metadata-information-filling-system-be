package com.metadata.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.metadata.common.lang.Result;
import com.metadata.entity.Textbook;
import com.metadata.service.TextbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TextbookController {
    @Autowired
    TextbookService textbookService;

    /**
     * 获取指定名称书籍
     * @param year 年份
     * @param batchIdx 批次
     * @param name 名称
     * @return textbook对象集
     */
    @GetMapping("textbooks")
    public Result selectTextbookByTextbookName(
            @RequestParam(name = "year") int year,
            @RequestParam(name = "batch_idx") int batchIdx,
            @RequestParam(name = "textbook_name") String name) {
        List<Textbook> textbookList = textbookService.selectTextbookByName(year, batchIdx, name);
        return Result.success(textbookList);
    }

    /**
     * 删除指定id书籍
     * @param id 教材 id
     * @return null
     */
    @DeleteMapping("textbook")
    @SaCheckRole(value = {"admin", "super_admin"}, mode = SaMode.OR)
    public Result deleteTextbookById(@RequestParam(name = "id") int id) {
        textbookService.deleteTextbook(id);
        return Result.success(null);
    }

    /**
     * 更新指定id书籍
     * @param textbook textbook对象
     * @return null
     */
    @PutMapping("textbook")
    @SaCheckRole(value = {"admin", "super_admin"}, mode = SaMode.OR)
    public Result updateTextbook(@RequestBody Textbook textbook) {
        textbookService.updateTextbook(textbook);
        return Result.success(null);
    }
}
