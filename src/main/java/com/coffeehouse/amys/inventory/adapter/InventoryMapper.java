package com.coffeehouse.amys.inventory.adapter;

import com.coffeehouse.amys.inventory.dataaccess.Inventory;
import com.coffeehouse.amys.inventory.dataaccess.InventoryRequestBody;
import com.coffeehouse.amys.inventory.dataaccess.InventoryResponseBody;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public abstract class InventoryMapper {

    public final static InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    public abstract Inventory mapRequest(final InventoryRequestBody inventoryRequestBody);

    @AfterMapping
    public void afterMapping(@MappingTarget Inventory inventory, InventoryRequestBody inventoryRequestBody) {
        inventory.set_id(UUID.randomUUID());
    }

    public abstract InventoryResponseBody map(final Inventory inventory);
}
