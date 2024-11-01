package com.mistergold.mistergold.adapters.persistence.entities.product;

import com.mistergold.mistergold.application.domain.InfoActivation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "produtos")
public class ProductEntity {
    @Id
    private String id;
    @Field(name = "nome")
    private String name;
    @Field(name = "url_imagem")
    private String imageUrl;
    @Field(name = "descricao")
    private String description;
    @Field(name = "tamanho")
    private Double size;
    @Field(name = "cor")
    private String color;
    @Field(name = "peso")
    private Double weight;
    private String material;
    @Field(name = "preco")
    private Double price;
    @Field(name = "quantidade")
    private Integer quantity;
    @Field(name = "status_de_ativacao")
    private InfoActivation infoActivation;
}
