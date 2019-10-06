package com.example.projectMGMT.serviceImpl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projectMGMT.dao.UserDao;
import com.example.projectMGMT.exception.ResourceNotFoundException;
import com.example.projectMGMT.models.Task;
import com.example.projectMGMT.models.User;
import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;
import com.example.projectMGMT.service.ObjectMapperUtility;
import com.example.projectMGMT.service.UserService;
import com.google.gson.Gson;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ObjectMapperUtility objectMapperUtility;


    private final Gson gson = new Gson();

    @Override
    public ResponseModel addUser( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
          
                User UserObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), User.class);
                
                 statuResponse.setRespObject(userDao.save(UserObj));
                 statuResponse.setStatusCode(0);
                 statuResponse.setMessage("Successfully Inserted");
               
                 List<User> UserList = userDao.findAll();
                 if (UserList != null) {
                     statuResponse.setStatusCode(0);
                     statuResponse.setRespList(UserList);
                 } else {
                     statuResponse.setMessage("No Data Found");
                     statuResponse.setStatusCode(3);
                 }
                 
                 
            
        } catch (Exception e) {
            e.printStackTrace();
            statuResponse.setMessage("Plese try after Sometime ");
            statuResponse.setStatusCode(1);
        } finally {
            return statuResponse;
        }
    }

    @Override
    public ResponseModel updateUser( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
            
                User UserObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), User.class);
                
                    User User = userDao.findById(UserObj.getUserId())
                            .orElseThrow(() -> new ResourceNotFoundException("User", "id", UserObj.getUserId()));
                    objectMapperUtility.nullAwareBeanCopy(User, UserObj);
                    userDao.save(User);
                    statuResponse.setStatusCode(0);
                    statuResponse.setMessage("Updated Successfully");
                    List<User> UserList = userDao.findAll();
                    if (UserList != null) {
                        statuResponse.setStatusCode(0);
                        statuResponse.setRespList(UserList);
                    } else {
                        statuResponse.setMessage("No Data Found");
                        statuResponse.setStatusCode(3);
                    }
           
        } catch (Exception e) {
            e.printStackTrace();
            statuResponse.setMessage("Plese try after Sometime ");
            statuResponse.setStatusCode(1);
        } finally {
            return statuResponse;
        }
    }

    @Override
    public ResponseModel deleteUser( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
           
                User UserObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), User.class);
                User User = userDao.findById(UserObj.getUserId())
                        .orElseThrow(() -> new ResourceNotFoundException("User", "id", UserObj.getUserId()));
                userDao.delete(User);
                ResponseEntity.ok().build();
                statuResponse.setStatusCode(0);
                statuResponse.setMessage("Deleted Successful");
                List<User> UserList = userDao.findAll();
                if (UserList != null) {
                    statuResponse.setStatusCode(0);
                    statuResponse.setRespList(UserList);
                } else {
                    statuResponse.setMessage("No Data Found");
                    statuResponse.setStatusCode(3);
                }
                
           
        } catch (Exception e) {
            e.printStackTrace();
            statuResponse.setMessage("Plese try after Sometime ");
            statuResponse.setStatusCode(1);
        } finally {
            return statuResponse;
        }
    }

    @Override
    public ResponseModel getAllUser() {
        ResponseModel statuResponse = new ResponseModel();
        try {
          
                List<User> UserList = userDao.findAll();
                if (UserList != null) {
                    statuResponse.setStatusCode(0);
                    statuResponse.setMessage("Success");
                    statuResponse.setRespList(UserList);
                } else {
                    statuResponse.setMessage("No Data Found");
                    statuResponse.setStatusCode(3);
                }
           
        } catch (Exception e) {
            e.printStackTrace();
            statuResponse.setMessage("Plese try after Sometime ");
            statuResponse.setStatusCode(1);
        } finally {
            return statuResponse;
        }
    }

    @Override
    public ResponseModel getUserById( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
           
                User UserObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), User.class);
                User resultObj = userDao.findById(UserObj.getUserId())
                        .orElseThrow(() -> new ResourceNotFoundException("User", "id", UserObj.getUserId()));

                if (resultObj != null) {
                    statuResponse.setMessage("Success");
                    statuResponse.setStatusCode(0);
                    statuResponse.setRespObject(resultObj);
                }
            
        } catch (Exception e) {
            e.printStackTrace();
            statuResponse.setMessage("Plese try after Sometime ");
            statuResponse.setStatusCode(1);
        } finally {
            return statuResponse;
        }
    }

	@Override
	public ResponseModel getUserByTId(RequestModel respObj) {
		 ResponseModel statuResponse = new ResponseModel();
	        try {
	           
	                Task taskObj = objectMapperUtility.jsonToObject(gson.toJson(respObj.getReqObject()), Task.class);
	                User resultObj = userDao.finduserbyTaskid(taskObj);
	                if (resultObj != null) {
	                    statuResponse.setMessage("Success");
	                    statuResponse.setStatusCode(0);
	                    statuResponse.setRespObject(resultObj);
	                    
	                }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            statuResponse.setMessage("Plese try after Sometime ");
	            statuResponse.setStatusCode(1);
	        } finally {
	            return statuResponse;
	        }
		
	}
}
