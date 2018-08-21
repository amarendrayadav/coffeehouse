package com.coffeehouse.amys.config;

import com.coffeehouse.amys.customer.dataaccess.Customer;
import com.coffeehouse.amys.customer.dataaccess.CustomerRepository;
import com.coffeehouse.amys.inventory.dataaccess.Coffee;
import com.coffeehouse.amys.inventory.dataaccess.CoffeeRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@EnableMongoRepositories(basePackages = "com.coffeehouse.amys")
@Configuration
@Slf4j
public class MongoConfig {
    /*@Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return strings -> {
            customerRepository.saveAll(createDummyCustomers());
        };
    }*/

    @Bean
    CommandLineRunner commandLineRunner(final CustomerRepository customerRepository, final CoffeeRepository coffeeRepository) {
        return strings -> {
            customerRepository.saveAll(createDummyCustomers());
            coffeeRepository.saveAll(createDummyCoffees());
        };
    }

    private List<Customer> createDummyCustomers() {
        final Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/customers.json"));
            List<Customer> result = Arrays.asList(gson.fromJson(br, Customer[].class));
            log.debug("result {} ", result);
            br.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private List<Coffee> createDummyCoffees() {
        final Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/coffees.json"));
            List<Coffee> result = Arrays.asList(gson.fromJson(br, Coffee[].class));
            log.debug("result {} ", result);
            br.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
