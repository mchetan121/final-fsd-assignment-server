package com.example.projectMGMT.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ParentTask")

public class ParentTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parentTaskId;

	@Column(name = "parentTaskName")
	private String parentTaskName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "projectId")
	private Project projectId;
	
	
	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public Long getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(Long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public String getParentTaskName() {
		return parentTaskName;
	}

	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}
	
}
