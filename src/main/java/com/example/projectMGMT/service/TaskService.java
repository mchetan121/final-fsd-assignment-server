package com.example.projectMGMT.service;

import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;


public interface TaskService {

    public ResponseModel addTask(RequestModel respObj);

    public ResponseModel updateTask(RequestModel respObj);

    public ResponseModel deleteTask(RequestModel respObj);

    public ResponseModel getAllTask();
    
    public ResponseModel getAllParentTask(RequestModel requestObj);

    public ResponseModel getTaskById(RequestModel respObj);

}
