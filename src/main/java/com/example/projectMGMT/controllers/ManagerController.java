package com.example.projectMGMT.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;
import com.example.projectMGMT.service.ManagerService;



@RestController
@RequestMapping("/")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @GetMapping("/msg")
	public String message() {
		return "----------------------";
	}

    
    @PostMapping(value = "insertManager")
    public ResponseModel addManager( @RequestBody RequestModel respObj) {
        return managerService.addManager( respObj);
    }

    @PostMapping(value = "updateManager")
    public ResponseModel updateManager( @RequestBody RequestModel respObj) {
        return managerService.updateManager( respObj);
    }

    @PostMapping(value = "deleteManager")
    public ResponseModel deleteManager( @RequestBody RequestModel respObj) {
        return managerService.deleteManager( respObj);
    }

    @GetMapping(value = "getallManager")
    public ResponseModel getAllManager() {
        return managerService.getAllManager();
    }


    @PostMapping(value = "getManagerbyid")
    public ResponseModel getManagerById( @RequestBody RequestModel respObj) {
        return managerService.getManagerById( respObj);
    }
}
