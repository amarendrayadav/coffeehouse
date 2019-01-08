package com.coffeehouse.amys.coffees.dataaccess;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@RequiredArgsConstructor
public class CoffeeRepositoryExtendedImpl implements CoffeeRepositoryExtended {
    private final MongoTemplate mongoTemplate;

    @Override
    public List<Coffee> getAllByInventoryNameLike(String inventory) {
        return null;
    }
}
