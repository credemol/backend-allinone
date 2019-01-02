package com.iclinicemr.training.message;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class MenuVO extends BaseVO {

    // validataion: https://blog.codecentric.de/en/2017/11/dynamic-validation-spring-boot-validation/

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("100.0")
    private BigDecimal price;

    @Size(max = 1000)
    private String description;

    @Size(max = 255)
    private String imageUrl;

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
