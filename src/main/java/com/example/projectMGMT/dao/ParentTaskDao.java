package com.example.projectMGMT.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projectMGMT.models.ParentTask;


@Repository
public interface ParentTaskDao extends JpaRepository<ParentTask, Long> {

	@Query("SELECT parenttask from ParentTask parenttask WHERE project_id=:projectId")
	List<ParentTask> getParentTaskByProjectId(@Param("projectId") Long projectId);

  
}
