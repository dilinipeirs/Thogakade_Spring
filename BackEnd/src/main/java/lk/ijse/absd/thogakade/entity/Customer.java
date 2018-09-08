package lk.ijse.absd.thogakade.entity;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;

    @Column(name = "CUST_NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Orders> orders;

    public Customer() {
    }

    public Customer(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
