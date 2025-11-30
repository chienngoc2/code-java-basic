package manager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Order implements Serializable{
    private static final long serialVersionUID = 1L; 
    private int orderID;
    private String customerCode;
    private String feastCode;
    private int numberOfTables;
    private LocalDate eventDate;
    private int totalCost;

    // Constructor
    public Order(int orderID, String customerCode, String feastCode, int numberOfTables, LocalDate eventDate, int totalCost) {
        this.orderID = orderID;
        this.customerCode = customerCode;
        this.feastCode = feastCode;
        this.numberOfTables = numberOfTables;
        this.eventDate = eventDate;
        this.totalCost = totalCost;
    }

    // Getters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setFeastCode(String feastCode) {
        this.feastCode = feastCode;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getFeastCode() {
        return feastCode;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public int getTotalCost() {
        return totalCost;
    }

    // Hiển thị thông tin đơn hàng
    @Override
    public String toString() {
        return String.format("Order ID: %d | Customer: %s | Set Menu: %s | Tables: %d | Date: %s | Total Cost: %,d Vnd",
                orderID, customerCode, feastCode, numberOfTables, eventDate, totalCost);
    }
     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return this.orderID == order.orderID; // So sánh theo Order ID để tránh trùng lặp
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID);
    }
}
