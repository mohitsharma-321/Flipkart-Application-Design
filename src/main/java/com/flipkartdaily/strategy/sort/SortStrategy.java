package com.flipkartdaily.strategy.sort;

import com.flipkartdaily.model.Item;

import java.util.Comparator;

public interface SortStrategy {
    Comparator<Item> getComparator();
}
