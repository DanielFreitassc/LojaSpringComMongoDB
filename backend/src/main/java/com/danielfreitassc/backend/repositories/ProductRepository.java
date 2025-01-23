package com.danielfreitassc.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.danielfreitassc.backend.models.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, Long>{
    
}
