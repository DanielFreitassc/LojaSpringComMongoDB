package com.danielfreitassc.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.danielfreitassc.backend.dtos.ProductRequestDto;
import com.danielfreitassc.backend.dtos.ProductResponseDto;
import com.danielfreitassc.backend.mappers.ProductMapper;
import com.danielfreitassc.backend.models.ProductEntity;
import com.danielfreitassc.backend.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private  final SequenceGeneratorService sequenceGeneratorService;

    public ProductResponseDto create(ProductRequestDto productRequestDto) {
        ProductEntity productEntity = productMapper.toEntity(productRequestDto);
        productEntity.setId(sequenceGeneratorService.generateSequence("tb_product_sequence"));
        return  productMapper.toDto(productRepository.save(productEntity));
    }

    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    public ProductResponseDto getById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto encontrado.");
        return productMapper.toDto(product.get());
    }

    public ProductResponseDto update(Long id, ProductRequestDto productRequestDto) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto encontrado.");
        ProductEntity productEntity = productMapper.toEntity(productRequestDto);
        productEntity.setId(id);
        return productMapper.toDto(productRepository.save(productEntity));
    }

    public ProductResponseDto delete(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto encontrado.");
        productRepository.delete(product.get());
        return productMapper.toDto(product.get());
    }
}
