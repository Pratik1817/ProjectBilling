package restaurant.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.billing.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
