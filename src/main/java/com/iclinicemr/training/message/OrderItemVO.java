package com.iclinicemr.training.message;

import java.util.UUID;

public class OrderItemVO {
    private UUID id;
    private OrderVO order;
    private MenuVO menu;
    private int quantity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OrderVO getOrder() {
        return order;
    }

    public void setOrder(OrderVO order) {
        this.order = order;
    }

    public MenuVO getMenu() {
        return menu;
    }

    public void setMenu(MenuVO menu) {
        this.menu = menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
