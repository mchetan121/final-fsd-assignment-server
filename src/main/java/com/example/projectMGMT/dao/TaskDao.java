package com.example.projectMGMT.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectMGMT.models.Task;


@Repository
public interface TaskDao extends JpaRepository<Task, Long> {

  
}
