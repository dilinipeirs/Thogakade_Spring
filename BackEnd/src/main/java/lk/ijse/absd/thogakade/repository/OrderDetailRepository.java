package lk.ijse.absd.thogakade.repository;

import lk.ijse.absd.thogakade.entity.OrderDetail;
import lk.ijse.absd.thogakade.entity.OrderDetailID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailID> {
}
