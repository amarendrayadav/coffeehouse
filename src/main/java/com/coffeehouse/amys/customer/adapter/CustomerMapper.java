package com.coffeehouse.amys.customer.adapter;

import com.coffeehouse.amys.customer.dataaccess.Customer;
import com.coffeehouse.amys.customer.dataaccess.CustomerRequestBody;
import com.coffeehouse.amys.customer.dataaccess.CustomerResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CustomerMapper {
    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    public abstract Customer mapRequest(final CustomerRequestBody requestBody);

    public abstract CustomerResponseBody mapEntity(final Customer customer);
}
