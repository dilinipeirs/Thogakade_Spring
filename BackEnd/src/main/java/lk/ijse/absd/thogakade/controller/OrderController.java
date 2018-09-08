package lk.ijse.absd.thogakade.controller;

import lk.ijse.absd.thogakade.dto.OrdersDTO;
import lk.ijse.absd.thogakade.service.custom.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrdersDTO> getAllOrders(){
        return orderService.findAll();
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public OrdersDTO findOrder(@PathVariable("id") String id){
        return orderService.find(Integer.parseInt(id));
    }

//    @DeleteMapping("/{id}")
//    public void deleteOrder(@PathVariable("id") String id){
//        orderService.delete(Integer.parseInt(id));
//    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void placeOrder(@PathVariable("id") String id,
                         @RequestBody OrdersDTO ordersDTO){
        orderService.save(Integer.parseInt(id),ordersDTO);
    }

    @PostMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editOrder(@PathVariable("id") String id,
                           @RequestBody OrdersDTO ordersDTO){
        orderService.update(Integer.parseInt(id),ordersDTO);
    }
}
