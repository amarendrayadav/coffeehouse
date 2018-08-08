package com.coffeehouse.amys.customer.apis;

import com.coffeehouse.amys.customer.dataaccess.Customer;
import com.coffeehouse.amys.customer.dataaccess.CustomerRepository;
import com.coffeehouse.amys.customer.dataaccess.CustomerRequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer addNewCustomer(CustomerRequestBody customerRequestBody){
        // TODO: check if already present

    }
}
