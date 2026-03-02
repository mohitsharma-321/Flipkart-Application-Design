package com.flipkartdaily.repository;

import com.flipkartdaily.model.Item;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InventoryRepository {
    private final Map<String, Item> inventory = new HashMap<>();

    private String key(String brand,String category) {
        return brand + "#" + category;
    }

    public void save(Item item) {
        inventory.put(key(item.getBrand(), item.getCategory()),item);
    }

    public Optional<Item> find(String brand, String category) {
        return Optional.ofNullable(inventory.get(key(brand, category)));
    }

    public Collection<Item> findAll() {
        return inventory.values();
    }
}
