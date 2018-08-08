package com.coffeehouse.amys.inventory.dataaccess;

import lombok.Data;

@Data
public class CoffeeResponseBody {
    private String name;
    private String description;
    private int totalServings;
}
