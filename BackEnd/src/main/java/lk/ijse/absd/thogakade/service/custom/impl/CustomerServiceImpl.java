package lk.ijse.absd.thogakade.service.custom.impl;

import lk.ijse.absd.thogakade.dto.CustomerDTO;
import lk.ijse.absd.thogakade.entity.Customer;
import lk.ijse.absd.thogakade.entity.SuperEntity;
import lk.ijse.absd.thogakade.repository.CustomerRepository;
import lk.ijse.absd.thogakade.service.custom.CustomerService;
import lk.ijse.absd.thogakade.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void save(int customerId, CustomerDTO dto) {
        if (dto.getId()!=customerId) {
            throw new RuntimeException("Customer ID mismatched");
        }
        Customer customer=(Customer)EntityDtoConvertor.convertToEntity(dto);
        customerRepository.save(customer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void update(int customerId, CustomerDTO dto) {
        if (dto.getId()!=customerId) {
            throw new RuntimeException("Customer ID mismatched");
        }
        if (customerRepository.existsById(customerId)) {
            Customer customer=(Customer)EntityDtoConvertor.convertToEntity(dto);
            customerRepository.save(customer);
        }else{
            throw new RuntimeException("Customer doesn't exist");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void delete(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerDTO find(int customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return (CustomerDTO) EntityDtoConvertor.convertToDTO(customer);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> all = customerRepository.findAll();
        return EntityDtoConvertor.convertToDtoList(all);

    }
}
