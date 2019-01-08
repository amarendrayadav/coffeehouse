package com.coffeehouse.amys.coffees.adapter;

import com.coffeehouse.amys.coffees.dataaccess.Coffee;
import com.coffeehouse.amys.coffees.dataaccess.CoffeeRequestBody;
import com.coffeehouse.amys.coffees.dataaccess.CoffeeResponseBody;

public class CoffeeAdapter {
    private final static CoffeeMapper coffeeMapper = CoffeeMapper.INSTANCE;

    public static Coffee convertRequest(final CoffeeRequestBody coffeeRequestBody) {
        return coffeeMapper.mapRequest(coffeeRequestBody);
    }

    public static CoffeeResponseBody convertEntity(final Coffee coffee) {
        return coffeeMapper.map(coffee);
    }
}
