package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cts.helper.CSVHelper;
import com.cts.message.ResponseMessage;
import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;
import com.cts.service.CSVService;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin("*")
@RestController
@Slf4j
@RequestMapping("/api/csv")
public class EmployeeController {
	
	 @Autowired
	  CSVService fileService;
	 
	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    if (CSVHelper.hasCSVFormat(file)) {
	      try {
	        fileService.save(file);
	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }
	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }
	  @GetMapping("/employees")
	  public ResponseEntity<List<Employee>> getAllEmployees() {
	    try {
	      List<Employee> employees = fileService.getAllEmployees();
	      if (employees.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(employees, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
//	  @GetMapping("user")
//	  User getUser(@RequestParam("userid") Integer id) {
//		  List<User> users = getUsers();
//		  for(User user: users) {
//			  if(user.getId()== id.intValue()) {
//				  return user;
//			  }
//		  }
//		  retrun null;
//	  }
//	  	@Autowired
//	  	private EmployeeRepository repository;
//
//	  	@GetMapping("/users")
//	  	public ResponseEntity<?> getUsers(@RequestParam double minSalary, @RequestParam double maxSalary,
//	  			@RequestParam int offset, @RequestParam int limit, @RequestParam String sort) {
//	  		String newSort = sort.substring(1);
//	  		if (newSort.equals("id")) {
//	  			if (sort.startsWith("-")) {
//	  				List<Employee> employees = repository.findBySalaryBetweenOrderByIdDesc(minSalary,maxSalary);
//	  				return new ResponseEntity<List<Employee>>(employees.subList(offset, Math.min(employees.size(), limit)),HttpStatus.OK);
//	  			} else {
//	  				List<Employee> employees = repository.findBySalaryBetweenOrderByIdAsc(minSalary,maxSalary);
//	  				return new ResponseEntity<List<Employee>>(employees.subList(offset, Math.min(employees.size(), limit)),HttpStatus.OK);
//	  			}
//	  		}
//	  		
//	  		if (newSort.equals("name")) {
//	  			if (sort.startsWith("-")) {
//	  				List<Employee> employees = repository.findBySalaryBetweenOrderByNameDesc(minSalary,maxSalary);
//	  				return new ResponseEntity<List<Employee>>(employees.subList(offset, Math.min(employees.size(), limit)),HttpStatus.OK);
//	  			} else {
//	  				List<Employee> employees = repository.findBySalaryBetweenOrderByNameAsc(minSalary,maxSalary);
//	  				return new ResponseEntity<List<Employee>>(employees.subList(offset, Math.min(employees.size(), limit)),HttpStatus.OK);
//	  			}
//	  		}
//	  		
//	  		if (newSort.equals("loginName")) {
//	  			if (sort.startsWith("-")) {
//	  				List<Employee> employees = repository.findBySalaryBetweenOrderByLoginNameDesc(minSalary,maxSalary);
//	  				return new ResponseEntity<List<Employee>>(employees.subList(offset, Math.min(employees.size(), limit)),HttpStatus.OK);
//	  			} else {
//	  				List<Employee> employees = repository.findBySalaryBetweenOrderByLoginNameAsc(minSalary,maxSalary);
//	  				return new ResponseEntity<List<Employee>>(employees.subList(offset, Math.min(employees.size(), limit)),HttpStatus.OK);
//	  			}
//	  		}
//	  		
//	  		if (newSort.equals("salary")) {
//	  			if (sort.startsWith("-")) {
//	  				List<Employee> employees = repository.findBySalaryBetweenOrderBySalaryDesc(minSalary,maxSalary);
//	  				return new ResponseEntity<List<Employee>>(employees.subList(offset, Math.min(employees.size(), limit)),HttpStatus.OK);
//	  			} else {
//	  				List<Employee> employees = repository.findBySalaryBetweenOrderBySalaryAsc(minSalary,maxSalary);
//	  				return new ResponseEntity<List<Employee>>(employees.subList(offset, Math.min(employees.size(), limit)),HttpStatus.OK);
//	  			}
//	  		}
//	  		
//	  		return new ResponseEntity<String>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
//
//	  	}
	  	@GetMapping("/api/users/{minSal}/{maxSal}")
	  	public ResponseEntity<List<Employee>> getAllUsers(@PathVariable("minSal") Double minS,
	  			@PathVariable("maxSal") Double maxS){
	  		try {
	  			System.out.println(minS);
	  			System.out.println(maxS);
	  			List<Employee> employees = CSVService.getFilteredUsers(minS,maxS);
	  			if (employees.isEmpty()) {
	  				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  			}
	  			return new ResponseEntity<>(employees,HttpStatus.OK);
	  		}catch(Exception e) {
	  			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR)
	  		}
	  	}
}
