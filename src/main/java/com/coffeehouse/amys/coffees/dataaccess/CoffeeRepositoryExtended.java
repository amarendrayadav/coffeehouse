package com.coffeehouse.amys.coffees.dataaccess;

import java.util.List;

public interface CoffeeRepositoryExtended {
    List<Coffee> getAllByInventoryNameLike(final String inventory);
}
