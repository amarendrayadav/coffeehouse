package com.coffeehouse.amys.orders.adapter;

import com.coffeehouse.amys.orders.dataaccess.Bill;
import com.coffeehouse.amys.orders.dataaccess.BillRequest;
import com.coffeehouse.amys.orders.dataaccess.BillResponse;
import com.coffeehouse.amys.orders.dataaccess.Order;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
@Slf4j
public abstract class BillMapper {

    public static final BillMapper INSTANCE = Mappers.getMapper(BillMapper.class);

    public abstract Bill mapRequest(final BillRequest request);

    @AfterMapping
    protected void calculateGrandTotal(@MappingTarget Bill bill, BillRequest billRequest) {
        // TODO: Calculation logic should be handled on FE side but we don't have such provision for now
        log.debug("Calculating Grand Total ");
        final int[] grandTotal = {0};
        billRequest.getOrders().entrySet().forEach(entry -> {
            final Order order = entry.getValue();
            int quantity = order.getQuantity();
            while (quantity != 0) {
                quantity--;
                grandTotal[0] += order.getPricePerItem();
            }
        });
        bill.setGrandTotal(grandTotal[0]);
    }

    public abstract BillResponse mapEntity(final Bill bill);
}
