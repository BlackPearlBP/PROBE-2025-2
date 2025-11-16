package com.probe.managesys.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Electronics extends Products {
    private boolean warranty;

    public Electronics(String name, Brand brand, String model,
                       String specifications, String description,
                       String imageUrl, double price) {
        super(name, brand, model, specifications, description, imageUrl, price);
    }
}
