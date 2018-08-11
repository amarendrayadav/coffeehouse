package com.coffeehouse.amys.orders.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BillRepository extends MongoRepository<Bill, UUID> {
}
