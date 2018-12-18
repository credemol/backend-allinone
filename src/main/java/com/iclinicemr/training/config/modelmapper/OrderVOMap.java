package com.iclinicemr.training.config.modelmapper;

import com.iclinicemr.training.domain.entity.Order;
import com.iclinicemr.training.message.OrderVO;
import org.modelmapper.PropertyMap;

public class OrderVOMap extends PropertyMap<Order, OrderVO> {
    @Override
    protected void configure() {

//        this.map().setItems(Object)
//        map().setItems(source.getItems());
//        map().

    }


}
