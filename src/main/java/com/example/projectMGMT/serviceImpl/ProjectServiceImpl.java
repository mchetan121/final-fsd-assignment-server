package com.example.projectMGMT.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projectMGMT.dao.ProjectDao;
import com.example.projectMGMT.exception.ResourceNotFoundException;
import com.example.projectMGMT.models.Project;
import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;
import com.example.projectMGMT.service.ObjectMapperUtility;
import com.example.projectMGMT.service.ProjectService;
import com.google.gson.Gson;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao ProjectDao;
    @Autowired
    private ObjectMapperUtility objectMapperUtility;


    private final Gson gson = new Gson();

    @Override
    public ResponseModel addProject( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
          
                Project projectObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Project.class);
                projectObj.setIsCompleted(false);
                 statuResponse.setRespObject(ProjectDao.save(projectObj));
                 statuResponse.setStatusCode(0);
                 statuResponse.setMessage("Successfully Inserted");
                 List<Project> ProjectList = ProjectDao.findAll();
                 if (ProjectList != null) {
                     statuResponse.setStatusCode(0);
                     
                     statuResponse.setRespList(ProjectList);
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
    public ResponseModel updateProject( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
            
                Project projectObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Project.class);
                
                    Project Project = ProjectDao.findById(projectObj.getProjectId())
                            .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectObj.getProjectId()));
                    objectMapperUtility.nullAwareBeanCopy(Project, projectObj);
                    ProjectDao.save(Project);
                    statuResponse.setStatusCode(0);
                    statuResponse.setMessage("Updated Successfully");
                    List<Project> ProjectList = ProjectDao.findAll();
                    if (ProjectList != null) {
                        statuResponse.setStatusCode(0);
                        
                        statuResponse.setRespList(ProjectList);
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
    public ResponseModel deleteProject( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
           
                Project projectObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Project.class);
                Project Project = ProjectDao.findById(projectObj.getProjectId())
                        .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectObj.getProjectId()));
                ProjectDao.delete(Project);
                ResponseEntity.ok().build();
                statuResponse.setStatusCode(0);
                statuResponse.setMessage("Deleted Successful");
                List<Project> ProjectList = ProjectDao.findAll();
                if (ProjectList != null) {
                    statuResponse.setStatusCode(0);
                    
                    statuResponse.setRespList(ProjectList);
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
    public ResponseModel getAllProject() {
        ResponseModel statuResponse = new ResponseModel();
        try {
          
                List<Project> ProjectList = ProjectDao.findAll();
                if (ProjectList != null) {
                    statuResponse.setStatusCode(0);
                    statuResponse.setMessage("Success");
                    statuResponse.setRespList(ProjectList);
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
    public ResponseModel getProjectById( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
           
                Project projectObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Project.class);
                Project resultObj = ProjectDao.findById(projectObj.getProjectId())
                        .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectObj.getProjectId()));

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
