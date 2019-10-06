package com.example.projectMGMT.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projectMGMT.dao.ManagerDao;
import com.example.projectMGMT.exception.ResourceNotFoundException;
import com.example.projectMGMT.models.Manager;
import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;
import com.example.projectMGMT.service.ManagerService;
import com.example.projectMGMT.service.ObjectMapperUtility;
import com.google.gson.Gson;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    
    @Autowired(required=true)
    private ManagerDao mgrdao;
    @Autowired
    private ObjectMapperUtility objectMapperUtility;


    private final Gson gson = new Gson();

    @Override
    public ResponseModel addManager( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
          
//                Manager ManagerObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Manager.class);
                List<Manager> mgrlist=objectMapperUtility.jsonArrayToObjectList(requestObj.getReqList(), Manager.class);
                for(Manager mg:mgrlist) {
                	mgrdao.save(mg);
                }
                
                
//                statuResponse.setRespObject(mgrdao.save(ManagerObj));
                 statuResponse.setStatusCode(0);
                 statuResponse.setMessage("Successfully Inserted");
               
            
        } catch (Exception e) {
            e.printStackTrace();
            statuResponse.setMessage("Plese try after Sometime ");
            statuResponse.setStatusCode(1);
        } finally {
            return statuResponse;
        }
    }

    @Override
    public ResponseModel updateManager( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
            
                Manager ManagerObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Manager.class);
                
                    Manager Manager = mgrdao.findById(ManagerObj.getManagerId())
                            .orElseThrow(() -> new ResourceNotFoundException("Manager", "id", ManagerObj.getManagerId()));
                    objectMapperUtility.nullAwareBeanCopy(Manager, ManagerObj);
                    mgrdao.save(Manager);
                    statuResponse.setStatusCode(0);
                    statuResponse.setMessage("Updated Successfully");
                
           
        } catch (Exception e) {
            e.printStackTrace();
            statuResponse.setMessage("Plese try after Sometime ");
            statuResponse.setStatusCode(1);
        } finally {
            return statuResponse;
        }
    }

    @Override
    public ResponseModel deleteManager( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
           
                Manager ManagerObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Manager.class);
                Manager Manager = mgrdao.findById(ManagerObj.getManagerId())
                        .orElseThrow(() -> new ResourceNotFoundException("Manager", "id", ManagerObj.getManagerId()));
                mgrdao.delete(Manager);
                ResponseEntity.ok().build();
                statuResponse.setStatusCode(0);
                statuResponse.setMessage("Deleted Successful");
           
        } catch (Exception e) {
            e.printStackTrace();
            statuResponse.setMessage("Plese try after Sometime ");
            statuResponse.setStatusCode(1);
        } finally {
            return statuResponse;
        }
    }

    @Override
    public ResponseModel getAllManager() {
        ResponseModel statuResponse = new ResponseModel();
        try {
          
                List<Manager> ManagerList = mgrdao.findAll();
                if (ManagerList != null) {
                    statuResponse.setStatusCode(0);
                    statuResponse.setMessage("Success");
                    statuResponse.setRespList(ManagerList);
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
    public ResponseModel getManagerById( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
           
                Manager ManagerObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Manager.class);
                Manager resultObj = mgrdao.findById(ManagerObj.getManagerId())
                        .orElseThrow(() -> new ResourceNotFoundException("Manager", "id", ManagerObj.getManagerId()));

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
