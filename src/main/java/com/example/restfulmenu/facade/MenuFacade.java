package com.example.restfulmenu.facade;

import com.example.restfulmenu.dto.MenuItemDto;
import com.example.restfulmenu.entities.Dish;
import com.example.restfulmenu.repository.MenuRepository;
import com.example.restfulmenu.service.MenuService;

import java.util.ArrayList;

public class MenuFacade {

    private final MenuService service;

    ArrayList<Dish> dishes;

    public MenuFacade(MenuRepository repository) {
        dishes = new ArrayList<>();
        service = new MenuService(repository);
    }

    public String showMenu() {
        dishes = service.updateDatabase();
        return service.buildMenu(dishes);
    }

    public String save(MenuItemDto dto) {
        service.save(new Dish(), dto.getName(), dto.getPrice());
        return service.buildMenu(dishes);
    }

    public String update(String id, MenuItemDto dto) {
        service.updateDish(id, dto.getName(), dto.getPrice());
        dishes = service.updateDatabase();
        return service.buildMenu(dishes);
    }

    public String deleteDish(String id) {
        dishes = service.deleteDish(id);
        return service.buildMenu(dishes);
    }

    public String getMenuItem(String id) {
        return service.getMenuItem(id).toString();
    }
}
