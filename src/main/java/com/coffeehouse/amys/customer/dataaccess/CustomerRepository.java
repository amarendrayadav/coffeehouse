package com.coffeehouse.amys.customer.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CustomerRepository extends MongoRepository<Customer, UUID> {

    Customer findByName(final String name);

    Customer findByPhoneNumber(final String phoneNumber);
}
