package lk.ijse.absd.thogakade.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ITEM")
public class Item extends SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_CODE")
    private int itemCode;

    @Column(name = "DESCRIPTION")
    private String desc;

    @Column(name = "QTY_IN_HAND")
    private int qty;

    @Column(name = "UNIT_PRICE")
    private double unitPrice;

    @OneToMany(mappedBy = "primaryKey.item")
    private List<OrderDetail> orderDetails;

    public Item() {
    }

    public Item(int itemCode, String desc, int qty, double unitPrice) {
        this.itemCode = itemCode;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", desc='" + desc + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
