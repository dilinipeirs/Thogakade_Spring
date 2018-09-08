package lk.ijse.absd.thogakade.dto;

import java.util.ArrayList;

public class OrdersDTO extends SuperDTO{
    private int id;
    private String date;
    private ArrayList<OrderDetailDTO> orderDetailList;
    private CustomerDTO customer;

    public OrdersDTO() {
    }

    public OrdersDTO(String date, ArrayList<OrderDetailDTO> orderDetailList, CustomerDTO customer) {
        this.date = date;
        this.orderDetailList = orderDetailList;
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<OrderDetailDTO> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(ArrayList<OrderDetailDTO> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "date='" + date + '\'' +
                ", orderDetailList=" + orderDetailList +
                ", customer=" + customer +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
