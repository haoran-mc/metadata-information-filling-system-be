package com.metadata.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.metadata.common.dto.GenerateBatchDto;
import com.metadata.common.dto.SpDto;
import com.metadata.common.lang.Result;
import com.metadata.entity.Batch;
import com.metadata.entity.Project;
import com.metadata.entity.Sp;
import com.metadata.entity.Textbook;
import com.metadata.service.ProjectService;
import com.metadata.service.SpService;
import com.metadata.service.TextbookService;
import com.metadata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpController {
    @Autowired
    SpService spService;

    @Autowired
    ProjectService projectService;

    @Autowired
    TextbookService textbookService;

    @PostMapping("metadata")
    public Result generateBatch(@RequestBody GenerateBatchDto generateBatchDto) {
        System.out.println(generateBatchDto);

        Batch batch = generateBatchDto.getBatch();
        Project project = generateBatchDto.getProject();
        Textbook textbook = generateBatchDto.getTextbook();
        Boolean hasProject = generateBatchDto.getHasProject();
        Boolean hasTextbook = generateBatchDto.getHasTextbook();
        List<String> projectExpand = generateBatchDto.getProjectExpand();
        List<String> textbookExpand = generateBatchDto.getTextbookExpand();

        JSONObject projectExpandJson = new JSONObject();
        JSONObject textbookExpandJson = new JSONObject();

        if (hasProject) {
            for (String s : projectExpand) {
                projectExpandJson.set(s, "1");
            }
            project.setExpand(JSONUtil.toJsonStr(projectExpandJson));
        }
        if (hasTextbook) {
            for (String s : textbookExpand) {
                textbookExpandJson.set(s, "1");
            }
            textbook.setExpand(JSONUtil.toJsonStr(textbookExpandJson));
        }
        System.out.println("project");
        System.out.println(project);

        spService.insertSpecialData(hasProject, project, hasTextbook, textbook, batch);

        return Result.success(null);
    }

    @GetMapping("sp")
    public Result getSp(
            @RequestParam(name = "year") int year,
            @RequestParam(name = "batch_idx") int batchIdx) {
        Sp sp = spService.getSpByYearBatchIdx(year, batchIdx);
        int projectId = sp.getProjectId();
        int textbookId = sp.getTextbookId();
        Project project = projectService.getProjectById(projectId);
        Textbook textbook = textbookService.getTextbookById(textbookId);
        return Result.success(MapUtil.builder()
                        .put("sp", sp)
                        .put("project", project)
                        .put("textbook", textbook)
                        .map()
                );
    }

    @GetMapping("spYearBatchIdx")
    public Result getSpByYearBatchIdx(
            @RequestParam(name = "year") int year,
            @RequestParam(name = "batch_idx") int batchIdx) {
        Sp sp = spService.getSpByYearBatchIdx(year, batchIdx);
        return Result.success(sp);
    }

    @GetMapping("spProjectTextbook")
    public Result getSpProjectAndTextbook(
            @RequestParam(name = "project_id") int projectId,
            @RequestParam(name = "textbook_id") int textbookId) {
        Project project = projectService.getProjectById(projectId);
        Textbook textbook = textbookService.getTextbookById(textbookId);
        SpDto spDto = new SpDto();
        spDto.setProject(project);
        spDto.setTextbook(textbook);
        return Result.success(spDto);
    }
}

