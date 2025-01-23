package com.danielfreitassc.backend.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDto(
    @NotBlank(message="O campo nome não pode estar em branco.")
    String name,
    @NotNull(message="O campo preço não pode ser nulo.")
    BigDecimal price,
    @NotBlank(message="O campo descrição não pode ser nulo.")
    String description
) {
    
}
