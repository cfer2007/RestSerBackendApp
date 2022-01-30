package com.restser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restser.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}
