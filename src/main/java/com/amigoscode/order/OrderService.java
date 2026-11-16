package com.amigoscode.order;

import com.amigoscode.order.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return Optional.of(orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id)));
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        Order ord = orderRepository
                .findById(order.getId())
                .orElseThrow(() -> new OrderNotFoundException(order.getId()));

            ord.setDescription(order.getDescription());
            ord.setInternalNotes(order.getInternalNotes());
            ord.setCustomerEmail(order.getCustomerEmail());
            ord.setStatus(order.getStatus());
            ord.setTotalAmount(order.getTotalAmount());
            ord.setOrderDate(order.getOrderDate());

            orderRepository.save(ord);
        }


    public boolean deleteOrder(Long id) {
        if (!orderRepository.existsById(id)){
            return false;
        }
        orderRepository.deleteById(id);
        return true;
    }

}
