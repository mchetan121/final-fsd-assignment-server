package com.example.projectMGMT.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;
import com.example.projectMGMT.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "insertUser")
    public ResponseModel addUser( @RequestBody RequestModel respObj) {
        return userService.addUser( respObj);
    }

    @PostMapping(value = "updateUser")
    public ResponseModel updateUser( @RequestBody RequestModel respObj) {
        return userService.updateUser( respObj);
    }

    @PostMapping(value = "deleteUser")
    public ResponseModel deleteUser( @RequestBody RequestModel respObj) {
        return userService.deleteUser( respObj);
    }

    @PostMapping(value = "getallUser")
    public ResponseModel getAllUser(@RequestBody RequestModel respObj) {
        return userService.getAllUser();
    }


    @PostMapping(value = "getUserbyid")
    public ResponseModel getUserById( @RequestBody RequestModel respObj) {
        return userService.getUserById( respObj);
    }
    @PostMapping(value = "getUserbytid")
    public ResponseModel getUserByTId( @RequestBody RequestModel respObj) {
        return userService.getUserByTId( respObj);
    }
}
