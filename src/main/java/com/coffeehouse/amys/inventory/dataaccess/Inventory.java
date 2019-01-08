package com.coffeehouse.amys.inventory.dataaccess;

import com.coffeehouse.amys.core.AbstractEntity;
import com.coffeehouse.amys.inventory.dataaccess.enums.InventoryCategoryEnum;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "inventory")
public class Inventory extends AbstractEntity {
    private String name;
    private String description;
    private InventoryCategoryEnum category;
}
