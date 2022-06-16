package com.cts.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cts.helper.CsvHelper;
import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;

@Service
public class CsvService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void save(MultipartFile file) {
		try {
			List<Employee> employees = CsvHelper.csvToEmployees(file.getInputStream());
			employeeRepository.saveAll(employees);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Transactional
	public List<Employee> getFilteredUsers(double minS, double maxS) {
		return employeeRepository.getFirst30FilteredUsers(minS, maxS);
	}
}