package com.br.burguesaBurguers.dto;

import com.br.burguesaBurguers.model.ProductType;

import java.math.BigDecimal;

public record ProductDTO(
        String name,
        String descricao,
        BigDecimal price,
        ProductType type
) {}
