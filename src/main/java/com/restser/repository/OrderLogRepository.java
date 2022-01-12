package com.restser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restser.model.OrderDetail;

public interface OrderLogRepository extends JpaRepository<OrderDetail, Long>{

}
