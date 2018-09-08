package lk.ijse.absd.thogakade.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class OrderDetailID implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    private Orders order;

    @ManyToOne(cascade = CascadeType.ALL) //cascadetype.persist?
    private Item item;

    public OrderDetailID() {
    }

    public OrderDetailID(Orders order, Item item) {
        this.order = order;
        this.item = item;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
