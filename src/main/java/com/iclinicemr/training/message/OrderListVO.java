package com.iclinicemr.training.message;

import com.iclinicemr.training.domain.entity.User;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class OrderListVO {
    @NotNull
    private User customer;

    @Max(1000)
    private String description;

    public OrderListVO(User customer, String description) {
        this.customer = customer;
        this.description = description;
    }

    public OrderListVO() {
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
