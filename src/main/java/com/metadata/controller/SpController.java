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
            @RequestParam(name = "batch_idx") int batch_idx) {
        Sp sp = spService.getSpByYearBatchIdx(year, batch_idx);
        return Result.success(sp);
    }
}

