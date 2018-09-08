package lk.ijse.absd.thogakade.dto;

public class OrderDetailDTO extends SuperDTO{
    private int orderID;
    private int itemID;
    private int qty;
    private double unitPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderID, int itemID, int qty, double unitPrice) {
        this.orderID = orderID;
        this.itemID = itemID;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItem(ItemDTO item) {
        this.itemID = itemID;
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
}
