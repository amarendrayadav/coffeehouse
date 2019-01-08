package com.coffeehouse.amys.coffees.adapter;

import com.coffeehouse.amys.coffees.dataaccess.Coffee;
import com.coffeehouse.amys.coffees.dataaccess.CoffeeRequestBody;
import com.coffeehouse.amys.coffees.dataaccess.CoffeeResponseBody;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public abstract class CoffeeMapper {

    public final static CoffeeMapper INSTANCE = Mappers.getMapper(CoffeeMapper.class);

    public abstract Coffee mapRequest(final CoffeeRequestBody coffeeRequestBody);

    @AfterMapping
    public void afterMapping(@MappingTarget Coffee coffee, CoffeeRequestBody coffeeRequestBody) {
        coffee.set_id(UUID.randomUUID());
    }

    public abstract CoffeeResponseBody map(final Coffee coffee);
}
