package com.example.projectMGMT.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectMGMT.models.Manager;





@Repository
public interface ManagerDao extends JpaRepository<Manager, Long> {

  
}
	