package com.app.cakefactory.cakes;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CakeItem {

    private final String id;
    private final String title;
    private final double price;
}
