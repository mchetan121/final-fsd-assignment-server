package com.example.projectMGMT.service;

import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;


public interface ProjectService {

    public ResponseModel addProject(RequestModel respObj);

    public ResponseModel updateProject(RequestModel respObj);

    public ResponseModel deleteProject(RequestModel respObj);

    public ResponseModel getAllProject();

    public ResponseModel getProjectById(RequestModel respObj);

}
