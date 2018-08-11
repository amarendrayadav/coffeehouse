package com.coffeehouse.amys.orders.dataaccess;

import com.coffeehouse.amys.core.AbstractEntity;
import com.coffeehouse.amys.customer.dataaccess.Customer;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "customer_bill")
public class Bill extends AbstractEntity {
    private Customer customer;
    private Map<String, Order> orders;
    private Integer grandTotal;
}
