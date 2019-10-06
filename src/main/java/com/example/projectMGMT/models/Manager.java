package com.example.projectMGMT.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
//import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@AllArgsConstructor
//@NoArgsConstructor
@Entity	
@Table(name = "Manager")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long managerId;

	@Column(name = "managerName")
	private String managerName;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "projectId")
//	private Project projectId;

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	

}
