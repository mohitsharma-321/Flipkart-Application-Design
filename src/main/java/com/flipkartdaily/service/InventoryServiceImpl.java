package com.flipkartdaily.service;

import com.flipkartdaily.exception.ItemNotFoundException;
import com.flipkartdaily.model.Item;
import com.flipkartdaily.repository.InventoryRepository;
import com.flipkartdaily.strategy.filter.ItemFilter;
import com.flipkartdaily.strategy.sort.PriceSortStrategy;
import com.flipkartdaily.strategy.sort.SortStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository repository) {
        this.inventoryRepository = repository;
    }

    @Override
    public void addItem(String brand, String categery, int price) {
        inventoryRepository.save(new Item(brand,categery,price));
    }

    @Override
    public void addInventory(String brand, String category, int quantity) {
        Item item = inventoryRepository.find(brand, category)
                .orElseThrow(()-> new ItemNotFoundException("Item Not Found ... "));
        item.addQuantity(quantity);
    }

    @Override
    public List<Item> search(List<ItemFilter> filters, SortStrategy sortStrategy) {

        if(sortStrategy == null)
            sortStrategy = new PriceSortStrategy(true);

        List<Item> items = inventoryRepository.findAll()
                .stream()
                .filter(item -> filters == null ||
                                    filters.stream().allMatch(f->f.applyFilter(item)))
                .sorted(sortStrategy.getComparator())
                .collect(Collectors.toList());  // Used chatgpt to change full logic into simple stream.

        return items;
    }
}
