package com.flipkartdaily.strategy.sort;

import com.flipkartdaily.model.Item;

import java.util.Comparator;

public class QuantitySortStrategy implements SortStrategy{

    private boolean asc;

    public QuantitySortStrategy(boolean asc) {
        this.asc = asc;
    }
    @Override
    public Comparator<Item> getComparator() {
        Comparator<Item> comparator = Comparator.comparing(Item::getPrice);

        if(!asc) {
            comparator = comparator.reversed();
        }
        return comparator;
    }
}
