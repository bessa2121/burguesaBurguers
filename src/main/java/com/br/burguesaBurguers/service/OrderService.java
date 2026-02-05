package com.br.burguesaBurguers.service;

import com.br.burguesaBurguers.dto.CreateOrderDTO;
import com.br.burguesaBurguers.dto.OrderResponseDTO;
import com.br.burguesaBurguers.model.ItemOrder;
import com.br.burguesaBurguers.model.Order;
import com.br.burguesaBurguers.model.Product;
import com.br.burguesaBurguers.repository.OrderRepository;
import com.br.burguesaBurguers.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(CreateOrderDTO dto) {

        Order order = new Order();

        List<ItemOrder> items = dto.itens()
                .stream()
                .map(itemOrderDTO -> {
            Product product = productRepository.findById(itemOrderDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            ItemOrder item = new ItemOrder();
            item.setProduct(product);
            item.setOrder(order);
            item.setQuantity(itemOrderDTO.quantity());
            item.setUnitPrice(product.getPrice());

            return item;
        }).toList();

        order.setItens(items);

        BigDecimal total = items.stream()
                .map(i -> i.getUnitPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotalAmount(total);

        return orderRepository.save(order);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Order removeItemFromOrder(Long orderId, Long productId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        List<ItemOrder> itens = order.getItens();

        ItemOrder itemToRemove = itens.stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item não encontrado no pedido"));

        itens.remove(itemToRemove);

        // Recalcula o total do pedido
        BigDecimal total = itens.stream()
                .map(i -> i.getUnitPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotalAmount(total);

        return orderRepository.save(order);
    }


}
