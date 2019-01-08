package com.coffeehouse.amys.inventory.dataaccess;

import com.coffeehouse.amys.inventory.dataaccess.enums.InventoryCategoryEnum;
import lombok.Data;

@Data
public class InventoryRequestBody {
    private String name;
    private String description;
    private InventoryCategoryEnum category;
}
