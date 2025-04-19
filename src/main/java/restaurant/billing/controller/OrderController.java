package restaurant.billing.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restaurant.billing.model.Order;
import restaurant.billing.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    ResponseEntity <Order>  createOrder (@RequestBody Order order)
    {
        Order savOrder =orderService.createOrder(order);
        return ResponseEntity.ok(savOrder);
    }

    @GetMapping
    ResponseEntity <List<Order>> getAllOrders()
    {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity <Order> getOrder(@PathVariable Long id)
    {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity <String> deleteById(@PathVariable Long id)
    {
        Boolean b = orderService.deleteById(id);
        if (b) {
            return ResponseEntity.ok("Order deleted successfully....");
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

}
