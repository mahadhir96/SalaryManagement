package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")

public class Employee {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "loginName")
	private String loginName;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private Double salary;

	public Employee() {

	}

	public Employee(String id, String loginName, String name, Double salary) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.name = name;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + id + ", LoginName=" + loginName + ", Name=" + name + ", Salary=" + salary + "]";
	}

}