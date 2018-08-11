package com.coffeehouse.amys.orders.apis;

import com.coffeehouse.amys.core.AbstractController;
import com.coffeehouse.amys.orders.dataaccess.BillRequest;
import com.coffeehouse.amys.orders.dataaccess.BillResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/bill")
public class BillController extends AbstractController {

    private final BillService billService;

    @RequestMapping(value = "/by-customer")
    public ResponseEntity<BillResponse> getCustomerBill(@RequestBody BillRequest billRequest) {
        log.debug("Request to get customer bill {} ", billRequest);
        return getResponse(billService.calculateCustomerBill(billRequest), HttpStatus.OK);
    }
}
