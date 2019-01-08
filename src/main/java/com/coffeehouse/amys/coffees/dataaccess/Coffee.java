package com.coffeehouse.amys.coffees.dataaccess;

import com.coffeehouse.amys.core.AbstractEntity;
import com.coffeehouse.amys.core.Reference;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "coffee")
public class Coffee extends AbstractEntity {
    private String name;
    private String description;
    private int totalServings;
    private Reference inventory;
}
