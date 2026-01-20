package com.br.burguesaBurguers.controller;

import com.br.burguesaBurguers.dto.CreateOrderDTO;
import com.br.burguesaBurguers.dto.OrderItemView;
import com.br.burguesaBurguers.dto.OrderResponseDTO;
import com.br.burguesaBurguers.model.Order;
import com.br.burguesaBurguers.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody CreateOrderDTO dto) {
        Order order = orderService.createOrder(dto);

        OrderResponseDTO response = new OrderResponseDTO(
                order.getId(),
                order.getItens().stream().map(item ->
                        new OrderItemView(
                                item.getProduct().getName(),
                                item.getQuantity(),
                                item.getUnitPrice()
                        )
                ).toList(),
                order.getTotalAmount(),
                order.getOrderDate()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping
    public ResponseEntity<OrderResponseDTO> deleteOrder(@RequestBody )
}
