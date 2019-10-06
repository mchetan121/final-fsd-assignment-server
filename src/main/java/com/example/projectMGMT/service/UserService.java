package com.example.projectMGMT.service;

import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;


public interface UserService {

    public ResponseModel addUser(RequestModel respObj);

    public ResponseModel updateUser(RequestModel respObj);

    public ResponseModel deleteUser(RequestModel respObj);

    public ResponseModel getAllUser();

    public ResponseModel getUserById(RequestModel respObj);

	public ResponseModel getUserByTId(RequestModel respObj);

}
