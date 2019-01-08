package com.coffeehouse.amys.inventory.adapter;

import com.coffeehouse.amys.inventory.dataaccess.Inventory;
import com.coffeehouse.amys.inventory.dataaccess.InventoryRequestBody;
import com.coffeehouse.amys.inventory.dataaccess.InventoryResponseBody;

public class InventoryAdapter {
    private final static InventoryMapper INVENTORY_MAPPER = InventoryMapper.INSTANCE;

    public static Inventory convertRequest(final InventoryRequestBody inventoryRequestBody) {
        return INVENTORY_MAPPER.mapRequest(inventoryRequestBody);
    }

    public static InventoryResponseBody convertEntity(final Inventory inventory) {
        return INVENTORY_MAPPER.map(inventory);
    }
}
