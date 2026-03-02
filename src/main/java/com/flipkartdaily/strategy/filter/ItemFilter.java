package com.flipkartdaily.strategy.filter;

import com.flipkartdaily.model.Item;

public interface ItemFilter {
    boolean applyFilter(Item item);
}
