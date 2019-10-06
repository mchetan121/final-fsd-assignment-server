package com.example.projectMGMT.service;

import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;

public interface ManagerService {

    public ResponseModel addManager(RequestModel respObj);

    public ResponseModel updateManager(RequestModel respObj);

    public ResponseModel deleteManager(RequestModel respObj);

    public ResponseModel getAllManager();

    public ResponseModel getManagerById(RequestModel respObj);

}
