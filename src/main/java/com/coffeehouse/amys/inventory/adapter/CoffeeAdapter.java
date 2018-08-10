package com.coffeehouse.amys.inventory.adapter;

import com.coffeehouse.amys.inventory.dataaccess.Coffee;
import com.coffeehouse.amys.inventory.dataaccess.CoffeeRequestBody;
import com.coffeehouse.amys.inventory.dataaccess.CoffeeResponseBody;

public class CoffeeAdapter {
    private final CoffeeMapper coffeeMapper = CoffeeMapper.INSTANCE;

    public Coffee convertRequest(final CoffeeRequestBody coffeeRequestBody) {
        return coffeeMapper.mapRequest(coffeeRequestBody);
    }

    public CoffeeResponseBody convertEntity(final Coffee coffee) {
        return coffeeMapper.map(coffee);
    }
}
