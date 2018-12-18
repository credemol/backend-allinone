package com.iclinicemr.training.service.impl;

import com.iclinicemr.training.domain.entity.Menu;
import com.iclinicemr.training.message.MenuVO;
import com.iclinicemr.training.service.MenuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.iclinicemr.training.domain.repository.MenuRepository;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;

    private ModelMapper modelMapper;

    @Autowired
    public MenuServiceImpl(ModelMapper modelMapper,
                           MenuRepository menuRepository) {
        this.modelMapper = modelMapper;
        this.menuRepository = menuRepository;
    }



    @Override
    public List<MenuVO> getAllMenus() {

        return this.menuRepository.findAll(Sort.by(Sort.Order.asc("price")))
                .stream().map( menu -> modelMapper.map(menu, MenuVO.class)).collect(toList());

    }

    @Override
    public Page<MenuVO> getMenus(Pageable pageRequest) {
        Page page = this.menuRepository.findAll(pageRequest);
        return page.map(menu -> modelMapper.map(menu, MenuVO.class));
//        return page;
    }

    @Override
    public MenuVO get(UUID id) throws EntityNotFoundException {
        //Menu entity = this.menuRepository.getOne(id);
        Menu entity = this.menuRepository.findById(id).orElse(null);
        //System.out.println("entity: " + entity);
        if(entity == null) {
            throw new EntityNotFoundException("menu id: " + id);
        }
        return modelMapper.map(entity, MenuVO.class);
    }

    public MenuVO create(MenuVO vo) {
        return modelMapper.map(this.menuRepository.save(modelMapper.map(vo, Menu.class)), MenuVO.class);
    }

    public MenuVO update(UUID id, MenuVO vo) throws EntityNotFoundException {
        Menu entity = menuRepository.findById(id).orElse(null);

        if(entity == null) {
            throw new EntityNotFoundException();
        }

        Menu converted = modelMapper.map(vo, Menu.class);

        BeanUtils.copyProperties(converted, entity, "id", "version");
        return modelMapper.map(this.menuRepository.save(entity), MenuVO.class);
    }

    public void delete(UUID id) throws EntityNotFoundException {
        Menu entity = menuRepository.findById(id).orElse(null);

        if(entity == null) {
            throw new EntityNotFoundException();
        }
        menuRepository.delete(entity);
    }
}
