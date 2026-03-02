package com.flipkartdaily.service;

import com.flipkartdaily.model.Item;
import com.flipkartdaily.strategy.filter.ItemFilter;
import com.flipkartdaily.strategy.sort.SortStrategy;

import java.util.List;

public interface InventoryService {

    void addItem(String brand, String categery, int price);

    void addInventory(String brand,String category,int quantity);

    List<Item> search(List<ItemFilter> filters, SortStrategy sortStrategy);
}
