package com.example.projectMGMT.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projectMGMT.dao.ParentTaskDao;
import com.example.projectMGMT.dao.TaskDao;
import com.example.projectMGMT.dao.UserDao;
import com.example.projectMGMT.exception.ResourceNotFoundException;
import com.example.projectMGMT.models.ParentTask;
import com.example.projectMGMT.models.Project;
import com.example.projectMGMT.models.Task;
import com.example.projectMGMT.models.User;
import com.example.projectMGMT.request.RequestModel;
import com.example.projectMGMT.response.ResponseModel;
import com.example.projectMGMT.service.ObjectMapperUtility;
import com.example.projectMGMT.service.TaskService;
import com.google.gson.Gson;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ParentTaskDao parentTaskdao;
    
    @Autowired
    private ObjectMapperUtility objectMapperUtility;


    private final Gson gson = new Gson();

    @Override
    public ResponseModel addTask( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
          
               Task taskObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Task.class);
               ParentTask ptobj=null;
               if(requestObj.getExtraVariable().equalsIgnoreCase("parentTask")) {
            	   if(taskObj.getProjectId()!=null && (taskObj.getTask()!=null || taskObj.getTask()!="")) {
            		   ptobj=new ParentTask();
            		   ptobj.setParentTaskName(taskObj.getTask());
            		   ptobj.setProjectId(taskObj.getProjectId());
            		   ptobj=parentTaskdao.saveAndFlush(ptobj);
            		   statuResponse.setStatusCode(0);
                       statuResponse.setMessage("Parent Task Successfully Inserted");
                     
            	   }   
               }else {
            	   taskObj=taskDao.saveAndFlush(taskObj);
            	   User userobj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqList().get(0)), User.class);
            	   userobj.setProjectId(taskObj.getProjectId());
            	   userobj.setTaskId(taskObj);;
            	   userDao.saveAndFlush(userobj);
                   statuResponse.setStatusCode(0);
                   statuResponse.setMessage("Successfully Inserted");  
               }

               List<Task> TaskList = taskDao.findAll();
               if (TaskList != null) {
                   statuResponse.setStatusCode(0);                   
                   statuResponse.setRespList(TaskList);
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
    public ResponseModel updateTask( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
            
                Task taskObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Task.class);
                
                    Task task = taskDao.findById(taskObj.getTaskId())
                            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskObj.getTaskId()));
                    objectMapperUtility.nullAwareBeanCopy(task, taskObj);
                    task.setStatus("New");
                    taskDao.saveAndFlush(task);
                    if(!requestObj.getReqList().isEmpty()) {
                       User userobj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqList().get(0)), User.class);
                      // User userobj1 = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqList().get(1)), User.class);
                       if(userobj!=null) {
                  		   //userDao.updateUserTask(task);
                    	 //  userobj1.setTaskId(null);
                    	   //userobj1.setProjectId(null);
                    	   //userDao.save(userobj1);
                  		   userobj.setProjectId(task.getProjectId());
                    	   userobj.setTaskId(task);
                    	   userDao.saveAndFlush(userobj);
                            
                  	   }
                         	
                    }
                    
                   
                    List<Task> TaskList = taskDao.findAll();
                    if (TaskList != null) {
                    	 statuResponse.setStatusCode(0);
                         statuResponse.setMessage("Updated Successfully");                   
                        statuResponse.setRespList(TaskList);
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
    public ResponseModel deleteTask( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
           
                Task taskObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Task.class);
                Task task = taskDao.findById(taskObj.getTaskId())
                        .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskObj.getTaskId()));
                task.setStatus("Complete");
                taskDao.saveAndFlush(task);
                ResponseEntity.ok().build();
                
                List<Task> TaskList = taskDao.findAll();
                if (TaskList != null) {
                	statuResponse.setStatusCode(0);
                    statuResponse.setMessage("Deleted Successful");                   
                    statuResponse.setRespList(TaskList);
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
    public ResponseModel getAllTask() {
        ResponseModel statuResponse = new ResponseModel();
        try {
          
                List<Task> TaskList = taskDao.findAll();
                if (TaskList != null) {
                    statuResponse.setStatusCode(0);
                    statuResponse.setMessage("Success");
                    statuResponse.setRespList(TaskList);
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
    public ResponseModel getAllParentTask(RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
        	 Project projectObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Project.class);
             if(projectObj!=null) {
            	 List<ParentTask> TaskList = parentTaskdao.getParentTaskByProjectId(projectObj.getProjectId());
                 if (TaskList != null) {
                     statuResponse.setStatusCode(0);
                     statuResponse.setMessage("Success");
                     statuResponse.setRespList(TaskList);
                 } else {
                     statuResponse.setMessage("No Data Found");
                     statuResponse.setStatusCode(3);
                 }	 
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
    public ResponseModel getTaskById( RequestModel requestObj) {
        ResponseModel statuResponse = new ResponseModel();
        try {
           
                Task taskObj = objectMapperUtility.jsonToObject(gson.toJson(requestObj.getReqObject()), Task.class);
                Task resultObj = taskDao.findById(taskObj.getTaskId())
                        .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskObj.getTaskId()));

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
