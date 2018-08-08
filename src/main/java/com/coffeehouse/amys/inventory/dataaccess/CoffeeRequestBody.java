package com.coffeehouse.amys.inventory.dataaccess;

import lombok.Data;

@Data
public class CoffeeRequestBody {
    private String name;
    private String description;
    private int totalServings;
}
