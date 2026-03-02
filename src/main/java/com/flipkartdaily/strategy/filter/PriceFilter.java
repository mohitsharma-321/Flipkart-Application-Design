package com.flipkartdaily.strategy.filter;

import com.flipkartdaily.model.Item;

import java.util.List;

public class PriceFilter implements ItemFilter {

    private Integer from;
    private Integer to;

    public PriceFilter(Integer from,Integer to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public boolean applyFilter(Item item) {

        if(from != null && item.getPrice() < from)
            return false;

        if(to!=null && item.getPrice() > to)
            return false;

        return true;
    }
}
