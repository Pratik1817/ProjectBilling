package restaurant.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restaurant.billing.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
 