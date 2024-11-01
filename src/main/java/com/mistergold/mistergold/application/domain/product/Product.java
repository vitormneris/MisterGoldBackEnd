package com.mistergold.mistergold.application.domain.product;

import com.mistergold.mistergold.application.domain.InfoActivation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private String imageUrl;
    private Double size;
    private String color;
    private Double weight;
    private String material;
    private String description;
    private Double price;
    private Integer quantity;
    private InfoActivation infoActivation;
}
