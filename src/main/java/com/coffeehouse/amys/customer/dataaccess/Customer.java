package com.coffeehouse.amys.customer.dataaccess;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer {
    @Id
    private String phoneNumber;
    private String name;
    private String emailId;
}
