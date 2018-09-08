package lk.ijse.absd.thogakade.service.custom.impl;

import lk.ijse.absd.thogakade.dto.ItemDTO;
import lk.ijse.absd.thogakade.dto.OrderDetailDTO;
import lk.ijse.absd.thogakade.dto.OrdersDTO;
import lk.ijse.absd.thogakade.entity.Orders;
import lk.ijse.absd.thogakade.repository.OrderRepository;
import lk.ijse.absd.thogakade.service.custom.ItemService;
import lk.ijse.absd.thogakade.service.custom.OrderService;
import lk.ijse.absd.thogakade.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemService itemService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(int id, OrdersDTO dto) {
        if (dto.getId() != id) {
            throw new RuntimeException("Item ID mismatched");
        }
        Orders order = (Orders) EntityDtoConvertor.convertToEntity(dto);
        orderRepository.save(order);

        for (OrderDetailDTO detail : dto.getOrderDetailList()
        ) {
            ItemDTO itemDTO = itemService.find(detail.getItemID());
            itemDTO.setQty(itemDTO.getQty() - detail.getQty());

            itemService.update(detail.getItemID(), itemDTO);
        }

    }

    @Override
    public void update(int id, OrdersDTO dto) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public void delete(int id) {
        throw new RuntimeException("cant delete an order!");
    }

    @Override
    public OrdersDTO find(int id) {
        Orders orders = orderRepository.findById(id).get();
        return (OrdersDTO) (EntityDtoConvertor.convertToDTO(orders));
    }

    @Override
    public List<OrdersDTO> findAll() {
        List<Orders> all = orderRepository.findAll();
        return EntityDtoConvertor.convertToDtoList(all);
    }
}
