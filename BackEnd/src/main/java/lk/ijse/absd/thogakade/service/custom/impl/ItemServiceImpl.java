package lk.ijse.absd.thogakade.service.custom.impl;

import lk.ijse.absd.thogakade.dto.ItemDTO;
import lk.ijse.absd.thogakade.entity.Item;
import lk.ijse.absd.thogakade.repository.ItemRepository;
import lk.ijse.absd.thogakade.service.custom.ItemService;
import lk.ijse.absd.thogakade.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void save(int id, ItemDTO dto) {
        if (dto.getId()!=id) {
            throw new RuntimeException("Item ID mismatched");
        }
        itemRepository.save((Item) EntityDtoConvertor.convertToEntity(dto));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void update(int id, ItemDTO dto) {
        if (dto.getId()!=id) {
            throw new RuntimeException("Item ID mismatched");
        }
        if (itemRepository.existsById(id)) {
            itemRepository.save((Item) EntityDtoConvertor.convertToEntity(dto));
        }else{
            throw new RuntimeException("Item doesn't exist");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void delete(int id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemDTO find(int id) {
        Item item = itemRepository.findById(id).get();
        return (ItemDTO) EntityDtoConvertor.convertToDTO(item);
    }

    @Override
    public List<ItemDTO> findAll() {
        List<Item> all = itemRepository.findAll();
        return EntityDtoConvertor.convertToDtoList(all);
    }
}
