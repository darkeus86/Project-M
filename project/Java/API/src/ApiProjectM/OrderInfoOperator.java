package ApiProjectM;

import java.io.Serializable;

public class OrderInfoOperator implements Serializable {
    private int orderId;
    private String orderDate;
    private String orderCity;
    private String orderStreet;
    private int orderHouse;
    private int orderHousing;
    private int orderRoom;
    private String orderTime;
    private String orderTitle;
    private String orderFirstName;
    private String orderSecondName;
    private String orderPhone;
    private String orderLoginId;
    private int price;
    private int status;



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

    public String getOrderCity() {
        return orderCity;
    }

    public void setOrderCity(String orderCity) {
        this.orderCity = orderCity;
    }

    public String getOrderStreet() {
        return orderStreet;
    }

    public void setOrderStreet(String orderStreet) {
        this.orderStreet = orderStreet;
    }

    public int getOrderHouse() {
        return orderHouse;
    }

    public void setOrderHouse(int orderHouse) {
        this.orderHouse = orderHouse;
    }

    public int getOrderHousing() {
        return orderHousing;
    }

    public void setOrderHousing(int orderHousing) {
        this.orderHousing = orderHousing;
    }

    public int getOrderRoom() {
        return orderRoom;
    }

    public void setOrderRoom(int orderRoom) {
        this.orderRoom = orderRoom;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getOrderFirstName() {
        return orderFirstName;
    }

    public void setOrderFirstName(String orderFirstName) {
        this.orderFirstName = orderFirstName;
    }

    public String getOrderSecondName() {
        return orderSecondName;
    }

    public void setOrderSecondName(String orderSecondName) {
        this.orderSecondName = orderSecondName;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderLoginId() {
        return orderLoginId;
    }

    public void setOrderLoginId(String orderLoginId) {
        this.orderLoginId = orderLoginId;
    }

    public int getOrderPrice() {
        return price;
    }

    public void setOrderPrice(int price) {
        this.price = price;
    }

    public int getStatus() {return status;}

    public void setStatus(int status) {this.status = status;}
}
