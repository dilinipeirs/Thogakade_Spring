package lk.ijse.absd.thogakade.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Orders extends SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int orderId;

    @Column(name = "ORDER_DATE")
    private String orderDate;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")   //has the foreign key customer_id. therefore the owner of the relationship
    private Customer customer;

    @OneToMany(mappedBy = "primaryKey.order")
    private List<OrderDetail> orderDetails;

    public Orders(int orderId, String orderDate, Customer customer, List<OrderDetail> orderDetails) {
        this.orderId=orderId;
        this.orderDate = orderDate;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public Orders() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
