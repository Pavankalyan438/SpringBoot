package com.capg.anuraag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.anuraag.entity.EmployeeDet;
import com.capg.anuraag.exception.CustomerException;
import com.capg.anuraag.service.EmployeeServiceI;

@RestController
@RequestMapping("/crud")
@CrossOrigin("http://localhost:4200")

public class EmployeRestController {
	@Autowired
	EmployeeServiceI service;

	@PostMapping("/create")
	public String createAccount(@RequestBody EmployeeDet emp) {
		return service.createAccount(emp);
	}

	@GetMapping("/findById/{id}")
	public  EmployeeDet findById(@PathVariable("id") int id) {
		EmployeeDet det = service.findById(id);
		if(det==null) {
			throw new CustomerException("No employee with that Id "+id);
		}
		else {
		return det;
	}}

	/*@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee id not present")
	@ExceptionHandler({ Exception.class })
	public void handleException() {

	}*/

	@GetMapping("/fetchAll")
	public List fetchAll() {
		return service.fetchAll();

	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		String msg = service.deleteById(id);
		if (msg.equals("no such record")) {
			throw new CustomerException("not there");
		} else {
			return msg;
		}
	}

	@PutMapping("/update")
	public String updateEmp(@RequestBody EmployeeDet emp) {
		String msg = service.updateEmp(emp);
		return msg;

	}

}
