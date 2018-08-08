package com.coffeehouse.amys.inventory.dataaccess;

import com.coffeehouse.amys.core.AbstractEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "coffee")
public class Coffee extends AbstractEntity {
    private String name;
    private String description;
    private int totalServings;
}
