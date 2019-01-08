package com.coffeehouse.amys.core;

public enum ObjectTypeEnum {
    CUSTOMER, COFFEE, ORDER, INVENTORY;

    public String getName() {
        return this.name().toUpperCase();
    }
}
