package com.restser.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.restser.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Long>{

}
