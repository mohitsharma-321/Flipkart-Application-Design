package com.flipkartdaily.strategy.filter;

import com.flipkartdaily.model.Item;

public class BrandFilter implements ItemFilter{
    @Override
    public boolean applyFilter(Item item) {
        return false;
    }
}
