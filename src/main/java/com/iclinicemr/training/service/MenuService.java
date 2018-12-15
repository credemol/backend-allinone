package com.iclinicemr.training.service;

import com.iclinicemr.training.message.MenuVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    List<MenuVO> getAllMenus();
    Page<MenuVO> getMenus(Pageable pageRequest);
    MenuVO get(UUID id);
    MenuVO create(MenuVO menu);
    MenuVO update(UUID id, MenuVO menu);
    void delete(UUID id);
}
