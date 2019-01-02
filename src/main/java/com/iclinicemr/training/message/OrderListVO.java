package com.iclinicemr.training.message;

import com.iclinicemr.training.domain.entity.User;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderListVO extends BaseVO {
    @NotNull
    private UserListVO customer;

    @Size(max = 1000)
    private String description;

    public OrderListVO(UserListVO customer, String description) {
        this.customer = customer;
        this.description = description;
    }

    public OrderListVO() {
    }

    public UserListVO getCustomer() {
        return customer;
    }

    public void setCustomer(UserListVO customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
