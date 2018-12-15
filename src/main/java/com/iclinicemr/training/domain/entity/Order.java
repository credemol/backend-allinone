package com.iclinicemr.training.domain.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="\"order\"")
public class Order extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private User customer;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    @Column(length = 1000)
    private String description;

    public Order() {
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
