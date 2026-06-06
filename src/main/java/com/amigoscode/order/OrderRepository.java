package com.amigoscode.order;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>(List.of(
            new Order(1L,
                    "Laptop and accessories",
                    "PENDING", 1299.99,
                    "john.doe@gmail.com",
                    LocalDate.of(2026, 1, 15),
                    "Fragile items, handle with care"),
            new Order(2L,
                    "Office chair",
                    "SHIPPED",
                    349.50,
                    "sarah.smith@gmail.com",
                    LocalDate.of(2026, 2, 3),
                    "Express delivery requested"),
            new Order(3L,
                    "Coffee machine",
                    "DELIVERED",
                    89.99,
                    "mike.jones@gmail.com",
                    LocalDate.of(2026, 3, 22),
                    "Gift wrap required")));


    private long nextId = 4L;

    public List<Order> findAll(){
        return orders;
    }

    public Optional<Order> findById(Long id){
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst();
    }

    public List<Order> findByStatus(String status){
        return orders.stream()
                .filter(order ->
                        order.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public Order save(Order order){
        order.setId(nextId++);
        orders.add(order);
        return order;
    }

    public void update(Order order){
        findById(order.getId()).ifPresent(existing -> {
            existing.setStatus(order.getStatus());
            existing.setCustomerEmail(order.getCustomerEmail());
            existing.setDescription(order.getDescription());
            existing.setInternalNotes(order.getInternalNotes());
            existing.setOrderDate(order.getOrderDate());
            existing.setTotalAmount(order.getTotalAmount());
        });

    }

    public boolean deleteById(Long id){
        return orders.removeIf(existing -> existing.getId().equals(id));
    }

}

// TODO: 12 - Create the OrderRepository class:
//  - Annotate with @Repository
//  - Add a private List<Order> field initialized with sample orders (use ArrayList)
//  - Add a private long nextId field starting at 4
//  - Implement these methods:
//    List<Order> findAll()
//    Optional<Order> findById(Long id)
//    List<Order> findByStatus(String status)
//    Order save(Order order) — sets the id and adds to the list
//    void update(Order order) — finds by id and updates fields
//    boolean deleteById(Long id) — removes from list
//  Hint: look at CustomerRepository for reference
