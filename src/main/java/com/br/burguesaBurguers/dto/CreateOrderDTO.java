package com.br.burguesaBurguers.dto;

import java.util.List;


public record CreateOrderDTO(
        List<ItemOrderDTO> itens
){}
