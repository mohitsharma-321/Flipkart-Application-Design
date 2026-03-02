package com.flipkartdaily.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private String brand;
    private String category;
    private int price;
    private int quantity;

    public Item(String brand,String category,int price) {
        if(brand == null || category == null || price < 0)
            System.out.println("Invalid Data Entered ....");

        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = 0;
    }

    public void addQuantity(int quantity) {
        if(quantity <=0)
            System.out.println("Quantity Should be positive ....");
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return brand + ", " + category + ", "+quantity;
    }
}
