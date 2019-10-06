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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Task")
public class Task {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	
	@Column(name = "task")
	private String task;
	
	
	@Column(name = "taskStartDate")
	private String taskStartDate;
	
	@Column(name = "taskEndDate")
	private String taskEndDate;
	
	@Column(name = "priority")
	private Long priority;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projectId")
    private Project projectId;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "userId")
//	private User userId;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentTaskId")
    private ParentTask parentTaskId;
	
	@Column(name = "status")
	private String status;
	
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	

	public String getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(String taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public String getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(String taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public ParentTask getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(ParentTask parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



}
