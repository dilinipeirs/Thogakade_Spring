package lk.ijse.absd.thogakade.controller;

import lk.ijse.absd.thogakade.dto.CustomerDTO;
import lk.ijse.absd.thogakade.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.findAll();
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO findCustomer(@PathVariable("id") String id){
        return customerService.find(Integer.parseInt(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") String id){
        customerService.delete(Integer.parseInt(id));
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCustomer(@PathVariable("id") String id,
                             @RequestBody CustomerDTO customerDTO){
//        return "it works!!!";
        customerService.save(Integer.parseInt(id),customerDTO);
    }

    @PostMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@PathVariable("id") String id,
                             @RequestBody CustomerDTO customerDTO){
        customerService.update(Integer.parseInt(id),customerDTO);
    }

}
