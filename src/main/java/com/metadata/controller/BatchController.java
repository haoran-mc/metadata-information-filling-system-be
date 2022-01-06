package com.metadata.controller;

import com.metadata.common.dto.UserFillingDto;
import com.metadata.common.lang.Result;
import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.service.BatchService;
import com.metadata.service.ProjectService;
import com.metadata.service.TextbookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BatchController {
    @Autowired
    BatchService batchService;

    @Autowired
    ProjectService projectService;

    @Autowired
    TextbookService textbookService;

    private final static Logger log = LoggerFactory.getLogger(BatchController.class);

    /**
     * 获取所有批次
     *
     * @return 所有批次列表
     */
    @GetMapping("batches")
    public Result getAllBatches() {
        List<Batch> batchList = batchService.getAllBatches();
        return Result.success(batchList);
    }


    /**
     * 获取指定批次的填报
     *
     * @param year      年份
     * @param batchIdx 批次
     * @param category  类别 "project" or "textbook"
     * @param pageNum  页码
     * @param pageSize 分页尺寸
     * @return project/textbook对象集
     */
    @GetMapping("batch/{year}/{batch_idx}")
    public Result getBatch(
            @PathVariable(name = "year") int year,
            @PathVariable(name = "batch_idx") int batchIdx,
            @RequestParam(name = "category") String category,
            @RequestParam(name = "page_num") int pageNum,
            @RequestParam(name = "page_size") int pageSize) {
        if (category.equals("project")) {
            List<Project> projectList = batchService.getBatchProject(year, batchIdx, pageNum, pageSize);
            return Result.success(projectList);
        } else if (category.equals("textbook")) {
            List<Textbook> textbookList = batchService.getBatchTextbook(year, batchIdx, pageNum, pageSize);
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
    @PostMapping("batch")
    // @SaCheckLogin
    // @SaCheckRole(value = {"admin", "super_admin"}, mode = SaMode.OR)
    public Result addFilling(@RequestBody UserFillingDto userFillingDto) {
        Project project = userFillingDto.getProject();
        Textbook textbook = userFillingDto.getTextbook();

        projectService.addProject(project);
        textbookService.addTextbook(textbook);
        return Result.success(null);
    }
}
