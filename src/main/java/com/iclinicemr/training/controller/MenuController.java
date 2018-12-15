package com.iclinicemr.training.controller;

import com.iclinicemr.training.service.MenuService;
import com.iclinicemr.training.message.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RequestMapping("/menu")
@RestController("menuController")
public class MenuController {

    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<Page<MenuVO>> getAllMenus(@RequestParam(name="page", defaultValue = "0") int page,
                                    @RequestParam(name="size", defaultValue = "100") int size,
                                    Pageable pageable) {
        return ResponseEntity.ok(menuService.getMenus(pageable));
//        return new ResponseEntity<Page<MenuVO>>(menuService.getMenus(pageable), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<MenuVO> createMenu(
            @Valid
            @RequestBody
            MenuVO menu) {
        return new ResponseEntity<MenuVO>(menuService.create(menu), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MenuVO> getMenu(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<MenuVO>(menuService.get(id), HttpStatus.OK);
        } catch(EntityNotFoundException ex) {
//            ex.printStackTrace();
            return new ResponseEntity<MenuVO>(HttpStatus.NOT_FOUND);
        } catch(Exception ex) {
//            ex.printStackTrace();
            //return new ResponseEntity<>(MenuVO)(HttpStatus.)
            throw ex;
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<MenuVO> updateMenu(
            @PathVariable("id") UUID id,
            @Valid @RequestBody MenuVO menu) {

        try {
            MenuVO updated = menuService.update(id, menu);
            return new ResponseEntity<MenuVO>(updated, HttpStatus.OK);

        } catch(EntityNotFoundException ex) {
            return new ResponseEntity<MenuVO>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable("id") UUID id) {
        try {
            menuService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(EntityNotFoundException ex) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
