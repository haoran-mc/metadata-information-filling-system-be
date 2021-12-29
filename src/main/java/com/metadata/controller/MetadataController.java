package com.metadata.controller;

import cn.hutool.json.JSONObject;
import com.metadata.common.dto.SpDto;
import com.metadata.common.lang.Result;
import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.service.MetadataService;
import com.metadata.service.BatchService;
import com.metadata.service.ProjectService;
import com.metadata.service.TextbookService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("metadatas")
public class MetadataController {
    @Autowired
    MetadataService metadataService;

    @Autowired
    ProjectService projectService;

    @Autowired
    TextbookService textbookService;

    /**
     * 获取所有批次
     *
     * @return 所有批次列表
     */
    @GetMapping
    public Result getAllBatches() {
        List<Batch> batchList = metadataService.getAllBatches();
        return Result.success(batchList);
    }

    /**
     * 生成批次
     * @param jsonObject { Project, Textbook, Batch }
     * @return 200
     */
    @PostMapping
    @RequiresAuthentication
    @RequiresRoles("admin")
    public Result generateBatch(@RequestBody JSONObject jsonObject) {
        Project project = jsonObject.get("project", Project.class);
        Textbook textbook = jsonObject.get("textbook", Textbook.class);
        Batch batch = jsonObject.get("batch", Batch.class);

        metadataService.insertSpecialData(project, textbook, batch);
        return Result.success(null);
    }

    @GetMapping("sp")
    public Result getSpProjectAndTextbook(
            @RequestParam(name = "projectId") int projectId,
            @RequestParam(name = "textbookId") int textbookId) {
        Project project = projectService.getProjectById(projectId);
        Textbook textbook = textbookService.getTextbookById(textbookId);
        SpDto spDto = new SpDto();
        spDto.setProject(project);
        spDto.setTextbook(textbook);
        return Result.success(spDto);
    }
}
