package com.example.restfulmenu.repository;

import com.example.restfulmenu.entities.Dish;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Dish, Long> {
}
