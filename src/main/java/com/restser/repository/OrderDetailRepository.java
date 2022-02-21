package com.restser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restser.model.OrderReservationDetail;

public interface OrderDetailRepository extends JpaRepository<OrderReservationDetail, Long>{

}
