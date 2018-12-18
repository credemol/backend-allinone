package com.iclinicemr.training.config.modelmapper;

import com.iclinicemr.training.domain.entity.OrderItem;
import com.iclinicemr.training.message.OrderItemVO;
import org.modelmapper.PropertyMap;


import java.util.List;

public class ListOrderItemVOMap extends PropertyMap<List<OrderItem>, List<OrderItemVO>> {
    @Override
    protected void configure() {

    }
}
