package lk.ijse.absd.thogakade.repository;

import lk.ijse.absd.thogakade.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
