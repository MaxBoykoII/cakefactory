package com.app.cakefactory.controllers;

import com.app.cakefactory.cakes.CakeItem;
import com.app.cakefactory.services.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private CatalogService catalogService;

    public HomeController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        List<CakeItem> items = catalogService.getCakeItems();

        model.addAttribute("cakeItems", items);

        return "home";
    }
}
