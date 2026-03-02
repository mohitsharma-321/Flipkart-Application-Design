package com.flipkartdaily.strategy.filter;

import com.flipkartdaily.model.Item;

public class PriceFilter implements ItemFilter {
    @Override
    public boolean applyFilter(Item item) {
        return false;
    }
}
