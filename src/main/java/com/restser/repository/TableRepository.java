package com.restser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restser.model.Tables;

public interface TableRepository extends JpaRepository<Tables, Long>{
	Tables findByIdTable(Long id);
}
