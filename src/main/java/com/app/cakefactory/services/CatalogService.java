package com.app.cakefactory.services;

import com.app.cakefactory.cakes.CakeItem;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CatalogService {
    private List<CakeItem> cakeItems = Arrays.asList(
                    new CakeItem("1-1", "Chocolate Cake", 10.00)
    );

    public List<CakeItem> getCakeItems() {
        return cakeItems;
    }
}
