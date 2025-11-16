package com.probe.managesys.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Electronics.class, name = "electronics"),
        //@JsonSubTypes.Type(value = Clothing.class, name = "clothing"),
        //@JsonSubTypes.Type(value = Furniture.class, name = "furniture")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Products {
    private String name;
    private Brand brand;
    private String model;
    private String specifications;
    private String description;
    private String imageUrl;
    private double price;
}
