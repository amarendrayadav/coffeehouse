package com.coffeehouse.amys.orders.apis;

import com.coffeehouse.amys.core.AbstractController;
import com.coffeehouse.amys.orders.dataaccess.BillRequest;
import com.coffeehouse.amys.orders.dataaccess.BillResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/bill")
public class BillController extends AbstractController {

    private final BillService billService;

    @ApiOperation("Get customer bill")
    @RequestMapping(value = "/by-customer", method = RequestMethod.GET)
    public ResponseEntity<BillResponse> getCustomerBill(@ApiParam(value = "Bill Request") @RequestBody final BillRequest billRequest) {
        log.debug("Request to get customer bill {} ", billRequest);
        return getResponse(billService.calculateCustomerBill(billRequest), HttpStatus.OK);
    }
}
