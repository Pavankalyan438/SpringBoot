package com.capg.anuraag.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.anuraag.entity.EmployeeDet;
import com.capg.anuraag.service.EmployeeServiceI;

@RestController
@RequestMapping("/crud")
@CrossOrigin("http://localhost:4333")

public class EmployeRestController {
	@Autowired
	EmployeeServiceI service;
	@PostMapping("/create")
	public String createAccount(@RequestBody EmployeeDet emp) {
		return service.createAccount(emp);	
	}
	@GetMapping("/findById/{id}")
	public Optional<EmployeeDet> findById(@PathVariable("id") int id) {
		return service.findById(id);	
	}
	
	
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		String msg= service.deleteById(id);
		if (msg==null) {
			throw new CustomerException("not there");
		} else {
			return new ResponseEntity<String>(msg, new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/fetchAll")
	public List fetchAll() {
		return service.fetchAll();
		
	}
	@GetMapping("/fetchSal/{sal1}")
	public Optional<EmployeeDet> fetchSalBt(@PathVariable int sal1) {
		return service.fetchSalBt(sal1);	
	}
	@GetMapping("/fetchSalBt/{sal1}/{sal2}")
	public List fetchSalBt(@PathVariable int sal1,@PathVariable int sal2) {
		return service.fetchSalBet(sal1,sal2);	
	}
	@PostMapping("/update")
	public String updateEmp(@RequestBody EmployeeDet emp) {
		return service.updateEmp(emp);
		
	}

}
