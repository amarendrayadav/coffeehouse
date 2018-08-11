package com.coffeehouse.amys.inventory.apis;

import com.coffeehouse.amys.core.AbstractController;
import com.coffeehouse.amys.inventory.dataaccess.CoffeeRequestBody;
import com.coffeehouse.amys.inventory.dataaccess.CoffeeResponseBody;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/inventory")
@Slf4j
@RequiredArgsConstructor
public class CoffeeController extends AbstractController {

    private final CoffeeService coffeeService;

    @ApiOperation(value = "Get all from inventory")
    @RequestMapping(value = "/coffee", method = RequestMethod.GET)
    public ResponseEntity<List<CoffeeResponseBody>> getInventoryStatus() {
        log.debug("get all from inventory ");
        return getResponse(coffeeService.getAllVarieties(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add new coffee variety")
    @RequestMapping(value = "/coffee", method = RequestMethod.POST)
    public ResponseEntity<CoffeeResponseBody> addNewVariety(@ApiParam(value = "Coffee Request Body") @RequestBody CoffeeRequestBody requestBody) {
        log.debug("add new coffee variety {}", requestBody);
        return getResponse(coffeeService.addNewVariety(requestBody), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get inventory status")
    @RequestMapping(value = "/coffee", method = RequestMethod.GET, params = "name")
    public ResponseEntity<List<CoffeeResponseBody>> getInventoryStatus(@ApiParam(value = "name")
                                                                       @RequestParam(value = "name") final String name) {
        log.debug("add new coffee variety for {} ", name);
        return getResponse(coffeeService.getInventoryStatus(name), HttpStatus.FOUND);
    }
}
