package com.coffeehouse.amys.customer.dataaccess;

import lombok.Data;

@Data
public class CustomerResponseBody {
    private String phoneNumber;
    private String name;
    private String emailId;
}
