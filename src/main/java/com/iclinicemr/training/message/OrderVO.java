package com.iclinicemr.training.message;

import com.iclinicemr.training.domain.entity.User;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.*;

public class OrderVO extends BaseVO {
    @NotNull
    private UserVO customer;
    @Max(1000)
    private String description;

    private List<OrderItemVO> items = new ArrayList<>();

    public OrderVO() {
    }

    public OrderVO(@NotNull UserVO customer, @Max(1000) String description) {
        this.customer = customer;
        this.description = description;
    }

    public UserVO getCustomer() {
        return customer;
    }

    public void setCustomer(UserVO customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderItemVO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemVO> items) {
        this.items = items;
    }
}
