
package com.Sharpest.sharpestapp.model.addRequestData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataAddRequser {

    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("orderStatusLookup")
    @Expose
    private OrderStatusLookup orderStatusLookup;

    @SerializedName("Offers")
    @Expose
    private Offers offers;

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


    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }
}
