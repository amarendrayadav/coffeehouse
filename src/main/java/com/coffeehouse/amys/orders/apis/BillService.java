package com.coffeehouse.amys.orders.apis;

import com.coffeehouse.amys.orders.adapter.BillAdapter;
import com.coffeehouse.amys.orders.dataaccess.BillRepository;
import com.coffeehouse.amys.orders.dataaccess.BillRequest;
import com.coffeehouse.amys.orders.dataaccess.BillResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BillService {
    private final BillRepository repository;
    private final BillAdapter adapter;

    public BillResponse calculateCustomerBill(final BillRequest billRequest) {
        log.debug("fetching bill for customer {} ", billRequest);
//        BillAdapter.convertRequest(billRequest);
        return null;
    }

//    public BillResponse
}
