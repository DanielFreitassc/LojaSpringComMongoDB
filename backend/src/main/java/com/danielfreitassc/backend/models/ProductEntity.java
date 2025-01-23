package com.danielfreitassc.backend.models;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="tb_product")
public class ProductEntity {
    @MongoId
    private Long id;
    private String name;
    
    @Field(targetType= FieldType.DECIMAL128)
    private BigDecimal price;
    private String description;
}
