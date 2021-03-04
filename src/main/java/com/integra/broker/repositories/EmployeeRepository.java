package com.integra.broker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.broker.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
