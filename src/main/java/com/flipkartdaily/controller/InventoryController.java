package com.flipkartdaily.controller;

import com.flipkartdaily.service.InventoryService;
import com.flipkartdaily.strategy.filter.BrandFilter;
import com.flipkartdaily.strategy.filter.CategoryFilter;
import com.flipkartdaily.strategy.filter.PriceFilter;
import com.flipkartdaily.strategy.sort.PriceSortStrategy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class InventoryController implements CommandLineRunner {
    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {

        service.addItem("Amul", "Milk", 100);
        System.out.println("Added Item -> Amul , Milk ,100\n");

        service.addItem("Amul", "Curd", 50);
        System.out.println("Added Item -> Amul , Curd ,50\n");

        service.addItem("Nestle", "Milk", 60);
        System.out.println("Added Item -> Nestle , Milk ,60\n");

        service.addItem("Nestle", "Curd", 90);
        System.out.println("Added Item -> Nestle , Curd ,90\n\n");


        service.addInventory("Amul", "Milk", 10);
        System.out.println("Added Inventory -> Amul , Milk ,10\n");

        service.addInventory("Nestle", "Milk", 5);
        System.out.println("Added Inventory -> Nestle , Milk ,5\n");

        service.addInventory("Nestle", "Curd", 10);
        System.out.println("Added Inventory -> Nestle , Curd ,10\n");

        service.addInventory("Amul", "Milk", 10);
        System.out.println("Added Inventory -> Amul , Milk ,10\n");

        service.addInventory("Amul", "Curd", 5);
        System.out.println("Added Inventory -> Amul , Curd ,5\n\n");

        System.out.println("\nSearch by Brand Nestle:");
        service.search(
                List.of(new BrandFilter(List.of("Nestle"))),
                new PriceSortStrategy(true)
        ).forEach(System.out::println);

        System.out.println("\nSearch Milk price desc:");
        service.search(
                List.of(new CategoryFilter(List.of("Milk"))),
                new PriceSortStrategy(false)
        ).forEach(System.out::println);

        System.out.println("\nSearch Milk + price range 70-100:");
        service.search(
                List.of(
                        new CategoryFilter(List.of("Milk")),
                        new PriceFilter(70, 100)
                ),
                new PriceSortStrategy(false)
        ).forEach(System.out::println);
    }
}
