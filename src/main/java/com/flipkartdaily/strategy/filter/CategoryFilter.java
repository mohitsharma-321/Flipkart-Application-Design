package com.flipkartdaily.strategy.filter;

import com.flipkartdaily.model.Item;

import java.util.List;

public class CategoryFilter implements ItemFilter{

    private List<String> categories;

    public CategoryFilter(List<String> categories) {
        this.categories = categories;
    }
    @Override
    public boolean applyFilter(Item item) {
        return categories.contains((item.getCategory()));
    }
}
