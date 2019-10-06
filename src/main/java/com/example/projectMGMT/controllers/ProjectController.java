package com.example.projectMGMT.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;
import com.example.projectMGMT.service.ProjectService;


@RestController
@RequestMapping("/")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "insertProject")
    public ResponseModel addProject( @RequestBody RequestModel respObj) {
        return projectService.addProject( respObj);
    }

    @PostMapping(value = "updateProject")
    public ResponseModel updateProject( @RequestBody RequestModel respObj) {
        return projectService.updateProject( respObj);
    }

    @PostMapping(value = "deleteProject")
    public ResponseModel deleteProject( @RequestBody RequestModel respObj) {
        return projectService.deleteProject( respObj);
    }

    @PostMapping(value = "getallProject")
    public ResponseModel getAllProject(@RequestBody RequestModel respObj) {
        return projectService.getAllProject();
    }


    @PostMapping(value = "getProjectbyid")
    public ResponseModel getProjectById( @RequestBody RequestModel respObj) {
        return projectService.getProjectById( respObj);
    }
}
