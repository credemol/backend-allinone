package com.iclinicemr.training.service;

import com.iclinicemr.training.domain.entity.Order;
import com.iclinicemr.training.message.OrderListVO;
import com.iclinicemr.training.message.OrderVO;
import com.iclinicemr.training.message.OrderWithPriceVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Page<OrderListVO> getOrders(Pageable pageRequest);
    OrderVO get(UUID id);

    List<OrderWithPriceVO> getOrdersWithPrice();

}
