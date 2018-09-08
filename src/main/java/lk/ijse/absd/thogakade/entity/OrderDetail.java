package lk.ijse.absd.thogakade.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDERDETAIL")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.order",
            joinColumns = @JoinColumn(name = "ORDER_ID")),
        @AssociationOverride(name = "primaryKey.item",
            joinColumns = @JoinColumn(name = "ITEM_CODE"))
})
public class OrderDetail extends SuperEntity{

    @EmbeddedId
    private OrderDetailID primaryKey = new OrderDetailID();

    @Column(name = "QTY_SOLD")
    private int qty;

    @Column(name = "UNIT_PRICE_SOLD")
    private double unitPrice;

    public OrderDetailID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(OrderDetailID primaryKey) {
        this.primaryKey = primaryKey;
    }

    public OrderDetail(OrderDetailID primaryKey, int qty, double unitPrice) {
        this.primaryKey = primaryKey;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetail() {
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

    @Transient
    public Orders getOrder(){
        return this.primaryKey.getOrder();
    }

    @Transient
    public Item getItem(){
        return this.primaryKey.getItem();
    }

    public void setOrder(Orders order){
        this.primaryKey.setOrder(order);
    }

    public void setItem(Item item){
        this.primaryKey.setItem(item);
    }

}
