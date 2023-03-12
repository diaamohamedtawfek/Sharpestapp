
package com.Sharpest.sharpestapp.model.DataResponseBooking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("orderDate")
    @Expose
    private String orderDate;
    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("orderStatusLookup")
    @Expose
    private OrderStatusLookup orderStatusLookup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OrderStatusLookup getOrderStatusLookup() {
        return orderStatusLookup;
    }

    public void setOrderStatusLookup(OrderStatusLookup orderStatusLookup) {
        this.orderStatusLookup = orderStatusLookup;
    }

}
