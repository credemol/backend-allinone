package com.iclinicemr.training.domain.entity;

import org.hibernate.annotations.BatchSize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="`menu`")
@BatchSize(size=50)
public class Menu extends BaseEntity{
    @Column(nullable = false, length = 255)
    private String name;

    @Column(precision = 12,  scale = 2, nullable = false)
    private BigDecimal price;

    @Column(length = 1000)
    private String description;

    @Column
    private String imageUrl;

    public Menu() {
    }

    public Menu(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
