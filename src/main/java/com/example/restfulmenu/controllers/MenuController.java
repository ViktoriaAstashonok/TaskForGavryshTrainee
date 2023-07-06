package com.example.restfulmenu.controllers;

import com.example.restfulmenu.dto.MenuItemDto;
import com.example.restfulmenu.facade.MenuFacade;
import com.example.restfulmenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

    private final MenuFacade menuFacade;

    @Autowired
    public MenuController(MenuRepository repository) {
        this.menuFacade = new MenuFacade(repository);
    }

    @GetMapping("/menu")
    public String showMenu() {
        return menuFacade.showMenu();
    }

    @GetMapping("/menu/{id}")
    public String getMenuItem(@PathVariable String id) {
        return menuFacade.getMenuItem(id);
    }

    @PostMapping("/menu")
    public String create(@RequestBody MenuItemDto dto) {
        menuFacade.save(dto);
        return menuFacade.showMenu();
    }

    @RequestMapping(value = "/{id}",
            produces = "application/json",
            method=RequestMethod.PUT)
    public String update(@PathVariable String id, @RequestBody MenuItemDto dto) {
        menuFacade.update(id, dto);
        return menuFacade.showMenu();
    }

    @DeleteMapping("/menu/{id}")
    public String deleteDish(@PathVariable String id) {
        menuFacade.deleteDish(id);
        return menuFacade.showMenu();
    }
}
