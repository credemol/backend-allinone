package com.iclinicemr.training.service.impl;

import com.iclinicemr.training.domain.entity.Menu;
import com.iclinicemr.training.domain.entity.Order;
import com.iclinicemr.training.domain.entity.OrderItem;
import com.iclinicemr.training.domain.repository.OrderRepository;
import com.iclinicemr.training.message.*;
import com.iclinicemr.training.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private ModelMapper modelMapper;

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(ModelMapper modelMapper, OrderRepository orderRepository) {
        this.modelMapper = modelMapper;

//        this.modelMapper.addMappings(new PropertyMap<List<OrderItem>, List<OrderItemVO>>() {
//            @Override
//            protected void configure() {
//
//            }
//        });

        this.orderRepository = orderRepository;
    }



    @Override
    @Transactional
    public Page<OrderListVO> getOrders(Pageable pageRequest) {
        Page page = this.orderRepository.findAll(pageRequest);
        return page.map(order -> modelMapper.map(order, OrderListVO.class));
        //return page;
    }

    @Override
    @Transactional
    public OrderVO get(UUID id) {
        //Menu entity = this.menuRepository.getOne(id);
        Order entity = this.orderRepository.findById(id).orElse(null);
        //System.out.println("entity: " + entity);
        if(entity == null) {
            throw new EntityNotFoundException("menu id: " + id);
        }
        return modelMapper.map(entity, OrderVO.class);
    }

    @Override
    public List<OrderWithPriceVO> getOrdersWithPrice() {

        return null;
    }
}
