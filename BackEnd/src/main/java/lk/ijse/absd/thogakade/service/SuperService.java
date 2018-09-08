package lk.ijse.absd.thogakade.service;

import lk.ijse.absd.thogakade.dto.SuperDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SuperService<T extends SuperDTO> {
    void save(int id,  T dto);

    void update(int id, T dto);

    void delete(int id);

    T find(int id);

    List<T> findAll();
}
