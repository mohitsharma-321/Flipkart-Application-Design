package com.flipkartdaily.strategy.sort;

import com.flipkartdaily.model.Item;

import java.util.Comparator;

public class PriceSortStrategy implements SortStrategy{

    private boolean asc;

    public PriceSortStrategy(boolean asc) {
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
