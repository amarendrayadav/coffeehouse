package com.coffeehouse.amys.coffees.dataaccess;

import com.coffeehouse.amys.core.Reference;
import lombok.Data;

@Data
public class CoffeeResponseBody {
    private String name;
    private String description;
    private int totalServings;
    private Reference inventory;
}
