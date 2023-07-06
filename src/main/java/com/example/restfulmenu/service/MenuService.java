package com.example.restfulmenu.service;

import com.example.restfulmenu.entities.Dish;
import com.example.restfulmenu.exceptions.NotFoundException;
import com.example.restfulmenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MenuService {
    private final MenuRepository repository;

    @Autowired
    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Dish> updateDatabase() {
        return (ArrayList<Dish>) repository.findAll();
    }

    public String buildMenu(ArrayList<Dish> dishes) {
        StringBuilder sb = new StringBuilder();
        for (Dish dish : dishes) {
            sb.append(dish.getId()).append("\t")
                    .append(dish.getName()).append("\t")
                    .append(dish.getPrice()).append("\n");
        }
        return sb.toString().trim();
    }

    public void save(Dish dish, String name, String price) {
        if (name != null) dish.setName(name);
        if (price != null) dish.setPrice(Double.parseDouble(price));
        repository.save(dish);
    }

    public void updateDish(String id, String name, String price) {
        Dish dish = repository.findById(Long.valueOf(id)).orElseThrow(NotFoundException::new);
        save(dish, name, price);
    }

    public ArrayList<Dish> deleteDish(String id) {
        repository.deleteById(Long.parseLong(id));
        return (ArrayList<Dish>) repository.findAll();
    }

    public Dish getMenuItem(String id) {
        return repository.findById(Long.valueOf(id)).orElseThrow(NoSuchFieldError::new);
    }
}
