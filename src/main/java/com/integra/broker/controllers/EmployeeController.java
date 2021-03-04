package com.integra.broker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.integra.broker.entities.Employee;
import com.integra.broker.exception.EmployeeNotFoundException;
import com.integra.broker.repositories.EmployeeRepository;

@RestController
public class EmployeeController {

	private final EmployeeRepository repository;

	public EmployeeController(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping("/employees")
	public List<Employee> all() {
		return repository.findAll();
	}

	@GetMapping("/employee/{id}")
	public Employee show(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@PutMapping("/employee/{id}")
	public Employee update(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repository.save(newEmployee);
		});
	}
	
	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
