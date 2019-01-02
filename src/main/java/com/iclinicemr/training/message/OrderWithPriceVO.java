package com.iclinicemr.training.message;

import com.iclinicemr.training.domain.entity.User;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OrderWithPriceVO {
    @NotNull
    private User customer;

    @Size(max = 1000)
    private String description;

    private BigDecimal totalPrice;

    public OrderWithPriceVO(User customer, String description) {
        this.customer = customer;
        this.description = description;
    }

    public OrderWithPriceVO() {
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
