package lk.ijse.absd.thogakade.util;

import lk.ijse.absd.thogakade.dto.*;
import lk.ijse.absd.thogakade.entity.*;
import lk.ijse.absd.thogakade.service.custom.ItemService;
import lk.ijse.absd.thogakade.service.custom.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EntityDtoConvertor {

    @Autowired
    static OrderService orderService;

    @Autowired
    static ItemService itemService;

    public static SuperEntity convertToEntity(SuperDTO dto) {
        if (dto instanceof CustomerDTO) {
            CustomerDTO customerDTO = (CustomerDTO) dto;
            return new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getCity());
        } else if (dto instanceof ItemDTO) {
            ItemDTO itemDTO = (ItemDTO) dto;
            return new Item(itemDTO.getId(), itemDTO.getDesc(), itemDTO.getQty(), itemDTO.getUnitPrice());
        } else if (dto instanceof OrdersDTO) {
            OrdersDTO ordersDTO = (OrdersDTO) dto;
            Orders orders = new Orders(ordersDTO.getId(), ordersDTO.getDate(), (Customer) convertToEntity(ordersDTO.getCustomer()),
                    convertToEntityList(ordersDTO.getOrderDetailList()));
            return orders;
        } else if (dto instanceof OrderDetailDTO) {
            OrderDetailDTO orderDetailDTO = (OrderDetailDTO) dto;
            Orders orders = (Orders) convertToEntity(orderService.find(orderDetailDTO.getOrderID()));
            Item item = (Item) convertToEntity(itemService.find(orderDetailDTO.getItemID()));
            OrderDetailID orderDetailID = new OrderDetailID(orders,item);
            return new OrderDetail(orderDetailID, orderDetailDTO.getQty(), orderDetailDTO.getUnitPrice());
        }
        return null;
    }

    public static SuperDTO convertToDTO(SuperEntity entity) {
        if (entity instanceof Customer) {
            Customer customer = (Customer) entity;
            return new CustomerDTO(customer.getId(), customer.getName(), customer.getCity());
        } else if (entity instanceof Item) {
            Item item = (Item) entity;
            return new ItemDTO(item.getItemCode(), item.getDesc(), item.getQty(), item.getUnitPrice());
        }
        return null;
    }

    public static List convertToDtoList(List list) {
        Object o = list.get(0);
        if (o instanceof Customer) {
            System.out.println("list has Customer");
            List<CustomerDTO> customerDTOS = new ArrayList<>();
            for (Object c : list
            ) {
                Customer customer = (Customer) c;
                customerDTOS.add((CustomerDTO) convertToDTO(customer));
            }
            return customerDTOS;
        } else if (o instanceof Item) {
            System.out.println("list has Item");
            List<ItemDTO> itemDTOS = new ArrayList<>();
            for (Object c : list
            ) {
                Item item = (Item) c;
                itemDTOS.add((ItemDTO) convertToDTO(item));
            }
            return itemDTOS;
        } else if (o instanceof Orders) {
            System.out.println("list has Order");
            List<OrdersDTO> ordersDTOS = new ArrayList<>();
            for (Object c : list
            ) {
                Orders orders = (Orders)c;
                ordersDTOS.add((OrdersDTO) convertToDTO(orders));
            }
            return ordersDTOS;
        }
        return null;
    }

    public static List convertToEntityList(List list) {
        Object o = list.get(0);
        if (o instanceof CustomerDTO) {
            System.out.println("list has CustomerDTO");
            List<Customer> customers = new ArrayList<>();
            for (Object c : list
            ) {
                CustomerDTO customerDTO = (CustomerDTO) c;
                customers.add((Customer) convertToEntity(customerDTO));
            }
            return customers;
        } else if (o instanceof Item) {
            System.out.println("list has ItemDTOs");
            List<Item> items = new ArrayList<>();
            for (Object c : list
            ) {
                ItemDTO itemDTO = (ItemDTO) c;
                items.add((Item) convertToEntity(itemDTO));
            }
            return items;
        } else if (o instanceof OrderDetailDTO) {
            System.out.println("list has OrderDetailDTO");
            List<OrderDetail> orderDetails = new ArrayList<>();
            for (Object c : list
            ) {
                OrderDetailDTO orderDetailDTO = (OrderDetailDTO) c;
                orderDetails.add((OrderDetail) convertToEntity(orderDetailDTO));
            }
            return orderDetails;
        }
        return null;
    }

}
