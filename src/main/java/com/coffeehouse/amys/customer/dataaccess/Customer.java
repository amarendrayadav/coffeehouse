package com.coffeehouse.amys.customer.dataaccess;

import com.coffeehouse.amys.core.AbstractEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer extends AbstractEntity {

    private String phoneNumber;
    private String name;
    private String emailId;
}
