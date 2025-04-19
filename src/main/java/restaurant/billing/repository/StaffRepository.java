package restaurant.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restaurant.billing.model.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    
    
}
