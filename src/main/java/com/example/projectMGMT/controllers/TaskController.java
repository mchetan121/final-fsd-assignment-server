package com.example.projectMGMT.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;
import com.example.projectMGMT.service.TaskService;


@RestController
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "insertTask")
    public ResponseModel addTask( @RequestBody RequestModel respObj) {
        return taskService.addTask( respObj);
    }

    @PostMapping(value = "updateTask")
    public ResponseModel updateTask( @RequestBody RequestModel respObj) {
        return taskService.updateTask( respObj);
    }

    @PostMapping(value = "deleteTask")
    public ResponseModel deleteTask( @RequestBody RequestModel respObj) {
        return taskService.deleteTask( respObj);
    }

    @PostMapping(value = "getallTask")
    public ResponseModel getAllTask(@RequestBody RequestModel respObj) {
        return taskService.getAllTask();
    }

    @PostMapping(value = "getallparenttaskbypid")
    public ResponseModel getAllParentTask(@RequestBody RequestModel respObj) {
        return taskService.getAllParentTask(respObj);
    }

    @PostMapping(value = "getTaskbyid")
    public ResponseModel getTaskById( @RequestBody RequestModel respObj) {
        return taskService.getTaskById( respObj);
    }
}
