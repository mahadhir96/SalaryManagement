package com.cts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.controller.EmployeeController;
import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;
import com.cts.service.CsvService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class SweChallengeApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	EmployeeRepository employeeRepository;

	@MockBean
	CsvService csvService;

	@Test
	public void testFindAll(){

		Employee employee1 = new Employee("e0001", "hpotter", "Harry Potter", 1234.50);
		Employee employee2 = new Employee("e0002", "rwesley", "Ron Weasley", 19234.50);
		Employee employee3 = new Employee("e0003", "ssnape", "snape", 4000.00);
		
		List<Employee> employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee3));

		Mockito.when(employeeRepository.findAll()).thenReturn(employees);

		List<Employee> resultList = employeeRepository.findAll();
		assertThat(resultList.size()).isEqualTo(3);
		assertThat(resultList.get(0).getName()).isEqualTo(employee1.getName());
		assertThat(resultList.get(1).getId()).isEqualTo(employee2.getId());
		assertThat(resultList.get(2).getSalary()).isEqualTo(employee3.getSalary());
	}
}