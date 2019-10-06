package com.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private String desig;
	@Column(name="password")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public String getPass() {
		return password;
	}
	public void setPass(String pass) {
		this.password = pass;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", desig=" + desig + ", pass=" + password + "]";
	}
	
	

}
