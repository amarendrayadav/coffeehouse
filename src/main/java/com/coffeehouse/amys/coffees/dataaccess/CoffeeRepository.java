package com.coffeehouse.amys.coffees.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface CoffeeRepository extends MongoRepository<Coffee, UUID> {
    List<Coffee> getAllByNameLike(final String name);
    List<Coffee> getAllByInventoryNameLike(final String inventory);
}
