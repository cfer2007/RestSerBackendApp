package com.restser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restser.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findByUid(String uid);

}
