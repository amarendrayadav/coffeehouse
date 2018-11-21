package com.coffeehouse.amys.customer.dataaccess;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class CustomerRequestBody {
    private String phoneNumber;
    private String name;
    private String emailId;
}
