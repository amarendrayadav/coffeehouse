package com.coffeehouse.amys.orders.adapter;

import com.coffeehouse.amys.orders.dataaccess.Bill;
import com.coffeehouse.amys.orders.dataaccess.BillRequest;
import com.coffeehouse.amys.orders.dataaccess.BillResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BillAdapter {
    private static final BillMapper billMapper = BillMapper.INSTANCE;

    public static Bill convertRequest(final BillRequest request) {
        return billMapper.mapRequest(request);
    }

    public static BillResponse convertEntity(final Bill bill) {
        return billMapper.mapEntity(bill);
    }
}
