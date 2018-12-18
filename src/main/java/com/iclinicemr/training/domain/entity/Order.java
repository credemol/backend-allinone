package com.iclinicemr.training.domain.entity;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="\"order\"")
public class Order extends BaseEntity {
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private User customer;

//    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    @ElementCollection
    @CollectionTable(name = "order_item", joinColumns = @JoinColumn(name="order_id"))
    @CollectionId(columns= {@Column(name="id")}, generator="uuid-generator", type=@Type(type="pg-uuid"))
    private List<OrderItem> items = new ArrayList<>();

    @Column(length = 1000)
    private String description;

    @Transient
    private BigDecimal totalPrice;

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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
