package com.coffeehouse.amys.inventory.dataaccess;

import com.coffeehouse.amys.inventory.dataaccess.enums.InventoryCategoryEnum;
import lombok.Data;

@Data
public class InventoryResponseBody {
    private String name;
    private String description;
    private InventoryCategoryEnum category;
}
