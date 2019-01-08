package com.coffeehouse.amys.inventory.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface InventoryRepository extends MongoRepository<Inventory, UUID> {
    List<Inventory> getAllByNameLike(final String name);
}
