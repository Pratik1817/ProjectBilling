package restaurant.billing.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.billing.model.Order;
import restaurant.billing.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order)
    {
        return orderRepository.save(order);
    } 

    public List<Order> getAll()
    {
        return orderRepository.findAll();
    }
    public Order getOrder(Long id)
    {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public Boolean deleteById(Long id)
    {
        Optional<Order> op = orderRepository.findById(id);
        if (op.isPresent()) {
            orderRepository.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }
}
