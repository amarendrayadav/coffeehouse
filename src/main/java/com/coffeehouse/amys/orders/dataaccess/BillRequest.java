package com.coffeehouse.amys.orders.dataaccess;

import com.coffeehouse.amys.customer.dataaccess.Customer;
import lombok.Data;

import java.util.Map;

@Data
public class BillRequest {
    private Customer customer;
    private Map<String, Order> orders;
    private Integer grandTotal;
}
