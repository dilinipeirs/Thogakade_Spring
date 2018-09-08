package lk.ijse.absd.thogakade.repository;

import lk.ijse.absd.thogakade.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
