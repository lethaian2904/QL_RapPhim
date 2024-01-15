package com.cybersoft.Controller;

import com.cybersoft.Entity.Order;
import com.cybersoft.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/{user_id}/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrderHistoryByUserId(@PathVariable("user_id") Long userId) {
        List<Order> orderHistory = orderService.getOrderHistoryByUserId(userId);
        return new ResponseEntity<>(orderHistory, HttpStatus.OK);
    }
}
