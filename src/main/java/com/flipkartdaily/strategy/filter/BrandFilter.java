package com.flipkartdaily.strategy.filter;

import com.flipkartdaily.model.Item;

import java.util.List;

public class BrandFilter implements ItemFilter{

    private List<String> brands;

    public BrandFilter(List<String> brands) {
        this.brands = brands;
    }
    @Override
    public boolean applyFilter(Item item) {
        return brands.contains(item.getBrand());
    }
}
