package com.br.burguesaBurguers.controller;

import com.br.burguesaBurguers.dto.CreateOrderDTO;
import com.br.burguesaBurguers.dto.OrderItemView;
import com.br.burguesaBurguers.dto.OrderResponseDTO;
import com.br.burguesaBurguers.model.Order;
import com.br.burguesaBurguers.service.OrderService;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(
            @RequestBody @Valid CreateOrderDTO dto
    ) {
        Order order = orderService.createOrder(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(order));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrderById(
            @PathVariable Long orderId
    ) {
        Order order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(toResponse(order));
    }


    @DeleteMapping("/{orderId}/items/{productId}")
    public ResponseEntity<OrderResponseDTO> removeItemFromOrder(
            @PathVariable Long orderId,
            @PathVariable Long productId
    ) {
        Order order = orderService.removeItemFromOrder(orderId, productId);
        return ResponseEntity.ok(toResponse(order));
    }

    // Metodo privado para retornar resposta
    private OrderResponseDTO toResponse(Order order) {
        return new OrderResponseDTO(
                order.getId(),
                order.getItens().stream()
                        .map(item -> new OrderItemView(
                                item.getProduct().getName(),
                                item.getQuantity(),
                                item.getUnitPrice()
                        ))
                        .toList(),
                order.getTotalAmount(),
                order.getOrderDate()
        );
    }
}
