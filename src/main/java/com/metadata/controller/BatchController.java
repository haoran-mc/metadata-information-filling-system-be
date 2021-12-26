package com.metadata.controller;

import cn.hutool.json.JSONObject;
import com.metadata.common.lang.Result;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("batches")
public class BatchController {
    @Autowired
    BatchService batchService;

    /**
     * 获取指定批次的填报
     *
     * @param year      年份
     * @param batch_idx 批次
     * @param category  类别 "project" or "textbook"
     * @param page_num  页码
     * @param page_size 分页尺寸
     * @return project/textbook对象集
     */
    @GetMapping
    public Result getBatch(@RequestParam(name = "year") int year, @RequestParam(name = "batchid") int batch,
                           @RequestParam(name = "category") int category) {
        List<Project> pj = batchService.getBatchProject(year, batch, category);
        List<Textbook> tb = batchService.getBatchTextbook(year, batch, category);
        if(pj != null){
            return Result.success(pj);
        }else if(tb != null){
            return Result.success(tb);
        }
        return Result.fail("请检查是否返回了正确的数据！");
    }

    /**
     * 用户填报数据
     *
     * @param userFillingDto 用户需要填写项目和教材
     * @return null
     */
    @PostMapping
    public Result addData(@RequestBody JSONObject jsonObject) {
        Project project = jsonObject.get("project", Project.class);
        Textbook textbook = jsonObject.get("textbook", Textbook.class);
        batchService.createFilling(project, textbook);
        return Result.success(null);
    }
}
