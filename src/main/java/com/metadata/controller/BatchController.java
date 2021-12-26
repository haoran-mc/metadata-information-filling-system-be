package com.metadata.controller;

import cn.hutool.json.JSONObject;
import com.metadata.common.dto.UserFillingDto;
import com.metadata.common.lang.Result;
import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.service.BatchService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("batches")
public class BatchController {
    @Autowired
    BatchService batchService;

    private final static Logger log = LoggerFactory.getLogger(BatchController.class);

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
    public Result getBatch(
            @RequestParam(name = "year") int year,
            @RequestParam(name = "batch_idx") int batch_idx,
            @RequestParam(name = "category") String category,
            @RequestParam(name = "page_num") int page_num,
            @RequestParam(name = "page_size") int page_size) {
        if (category.equals("project")) {
            List<Project> projectList = batchService.getBatchProject(year, batch_idx, page_num, page_size);
            return Result.success(projectList);
        } else if (category.equals("textbook")) {
            List<Textbook> textbookList = batchService.getBatchTextbook(year, batch_idx, page_num, page_size);
            return Result.success(textbookList);
        } else {
            log.error("数据传送失败");
            return Result.fail("查询失败");
        }
    }

    /**
     * 用户填报数据
     *
     * @param userFillingDto 用户需要填写项目和教材
     * @return null
     */
    @PostMapping
    @RequiresAuthentication
    public Result addFilling(@RequestBody UserFillingDto userFillingDto) {
        Project project = userFillingDto.getProject();
        Textbook textbook = userFillingDto.getTextbook();
        batchService.addFilling(project, textbook);
        return Result.success(null);
    }
}
