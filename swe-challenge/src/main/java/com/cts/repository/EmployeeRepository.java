package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,String>{
//
//	List<Employee> findBySalaryBetweenOrderByIdDesc(double minSalary, double maxSalary);
//
//	List<Employee> findBySalaryBetweenOrderByIdAsc(double minSalary, double maxSalary);
//
//	List<Employee> findBySalaryBetweenOrderByNameDesc(double minSalary, double maxSalary);
//
//	List<Employee> findBySalaryBetweenOrderByNameAsc(double minSalary, double maxSalary);
//
//	List<Employee> findBySalaryBetweenOrderBySalaryDesc(double minSalary, double maxSalary);
//
//	List<Employee> findBySalaryBetweenOrderBySalaryAsc(double minSalary, double maxSalary);
//
//	List<Employee> findBySalaryBetweenOrderByLoginNameDesc(double minSalary, double maxSalary);
//
//	List<Employee> findBySalaryBetweenOrderByLoginNameAsc(double minSalary, double maxSalary);
	@Query(value = "select u from Employee u where u.salary>=:minS and u.salary<=:maxS")

	List<Employee> getFilteredUsers(@Param("minS") double minS, @Param("maxS") double maxS);
}
