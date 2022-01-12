package com.restser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restser.model.ReservationDetail;

public interface ReservationLogRepository extends JpaRepository<ReservationDetail, Long>{

}
