package com.cts.service;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cts.helper.CSVHelper;
import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;

@Service
public class CSVService {
	
	 @Autowired
	  EmployeeRepository Erepo;
	  public void save(MultipartFile file) {
	    try {
	      List<Employee> employees = CSVHelper.csvToEmployees(file.getInputStream());
	      Erepo.saveAll(employees);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }
	  public List<Employee> getAllEmployees() {
	    return Erepo.findAll();
	  }
	
	  public List<Employee> getFilteredUsers(Double minS, Double maxS) {
		// TODO Auto-generated method stub
		return Erepo.getFilteredUsers(minS, maxS);
	}
}