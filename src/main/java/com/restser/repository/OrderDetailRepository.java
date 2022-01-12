package com.restser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restser.model.OrderDish;

public interface OrderDetailRepository extends JpaRepository<OrderDish, Long>{

}
