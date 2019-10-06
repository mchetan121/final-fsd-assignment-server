package com.example.projectMGMT.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projectMGMT.models.Task;
import com.example.projectMGMT.models.User;


@Repository
public interface UserDao extends JpaRepository<User, Long> {

	@Query("select user from User user where task_id=:#{#taskObj.taskId} and project_id=:#{#taskObj.projectId}")
	User finduserbyTaskid(@Param("taskObj") Task taskObj);

	@Query("update User set task_id=null where task_id=:#{#task.taskId} and project_id=:#{#task.projectId}")
	void updateUserTask(@Param("task") Task task);

  
}
