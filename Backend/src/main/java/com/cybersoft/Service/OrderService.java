package com.cybersoft.Service;

import com.cybersoft.Entity.Order;
import com.cybersoft.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrderHistoryByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
