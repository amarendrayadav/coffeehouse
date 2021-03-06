package com.coffeehouse.amys.orders.dataaccess;

import com.coffeehouse.amys.customer.dataaccess.Customer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Data
public class BillResponse {

    private Customer customer;
    private Map<String, Order> orders;
    private Integer grandTotal;
}
