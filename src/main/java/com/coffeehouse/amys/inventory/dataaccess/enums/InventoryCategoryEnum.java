package com.coffeehouse.amys.inventory.dataaccess.enums;

public enum InventoryCategoryEnum {
    COFFEES, SANDWICHES, MILKSHAKES;

    public String getName() {
        return this.name().toUpperCase();
    }
}