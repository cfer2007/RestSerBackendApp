package com.restser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restser.model.ReservationDetail;

public interface ReservationDetailRepository extends JpaRepository<ReservationDetail, Long>{

}
