package com.coffeehouse.amys.customer.adapter;

import com.coffeehouse.amys.customer.dataaccess.Customer;
import com.coffeehouse.amys.customer.dataaccess.CustomerRequestBody;
import com.coffeehouse.amys.customer.dataaccess.CustomerResponseBody;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerAdapter {
    private static CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public static Customer convertRequest(final CustomerRequestBody requestBody) {
        return customerMapper.mapRequest(requestBody);
    }

    public static CustomerResponseBody convertEntity(final Customer customer) {
        return customerMapper.mapEntity(customer);
    }
}
