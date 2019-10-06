package com.example.projectMGMT.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectMGMT.models.Project;

@Repository
public interface ProjectDao extends JpaRepository<Project, Long> {

  
}
