package com.br.burguesaBurguers.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record CreateOrderDTO(

        @NotNull(message = "Lista de itens é obrigatória")
        @NotEmpty(message = "O pedido deve conter ao menos um item")
        List<ItemOrderDTO> itens

) {}
