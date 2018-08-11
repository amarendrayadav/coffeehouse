package com.coffeehouse.amys.orders.dataaccess;

import lombok.Data;

@Data
public class Order {
    private Integer quantity;
    private Integer pricePerItem;
    private Integer totalPrice;
}
