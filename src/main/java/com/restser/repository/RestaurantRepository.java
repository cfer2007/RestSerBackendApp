package com.restser.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.restser.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
