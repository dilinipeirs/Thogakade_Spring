package lk.ijse.absd.thogakade.repository;

import lk.ijse.absd.thogakade.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
