package restaurant.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.billing.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
    
}

