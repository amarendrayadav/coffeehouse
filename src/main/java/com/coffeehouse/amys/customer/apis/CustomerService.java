package com.coffeehouse.amys.customer.apis;

import com.coffeehouse.amys.customer.adapter.CustomerAdapter;
import com.coffeehouse.amys.customer.dataaccess.Customer;
import com.coffeehouse.amys.customer.dataaccess.CustomerRepository;
import com.coffeehouse.amys.customer.dataaccess.CustomerRequestBody;
import com.coffeehouse.amys.customer.dataaccess.CustomerResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerResponseBody addNewCustomer(CustomerRequestBody customerRequestBody) {
        final Customer customer = customerRepository.save(CustomerAdapter.convertRequest(customerRequestBody));
        return CustomerAdapter.convertEntity(customer);
    }

    public CustomerResponseBody getCustomerByName(final String name) {
        return CustomerAdapter.convertEntity(customerRepository.findByName(name));
    }

    public CustomerResponseBody getCustomerByPhone(final String phoneNumber) {
        return CustomerAdapter.convertEntity(customerRepository.findByPhoneNumber(phoneNumber));
    }
}
