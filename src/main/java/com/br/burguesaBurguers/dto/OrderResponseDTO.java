package com.br.burguesaBurguers.dto;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponseDTO(
        Long orderId,
        List<OrderItemView> items,
        BigDecimal totalAmount,
        LocalDateTime orderDate
) {}
