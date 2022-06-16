package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	@Query(value = "select employee from Employee employee where employee.salary>=:minS and employee.salary<=:maxS")

	List<Employee> getFirst30FilteredUsers(@Param("minS") double minS, @Param("maxS") double maxS);
}
