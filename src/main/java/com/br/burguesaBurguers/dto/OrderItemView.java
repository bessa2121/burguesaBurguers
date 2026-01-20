package com.br.burguesaBurguers.dto;

import java.math.BigDecimal;

public record OrderItemView(
        String productName,
        int quantity,
        BigDecimal unitPrice
) {}
