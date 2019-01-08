package com.coffeehouse.amys.coffees.apis;

import com.coffeehouse.amys.core.AbstractController;
import com.coffeehouse.amys.coffees.dataaccess.CoffeeRequestBody;
import com.coffeehouse.amys.coffees.dataaccess.CoffeeResponseBody;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/coffees")
@Slf4j
@RequiredArgsConstructor
public class CoffeeController extends AbstractController {

    private final CoffeeService coffeeService;

    @ApiOperation(value = "Get all from coffees")
    @RequestMapping(value = "/coffee", method = RequestMethod.GET)
    public ResponseEntity<List<CoffeeResponseBody>> getInventoryStatus() {
        log.debug("get all from coffees ");
        return getResponse(coffeeService.getAllVarieties(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add new coffee variety")
    @RequestMapping(value = "/coffee", method = RequestMethod.POST)
    public ResponseEntity<CoffeeResponseBody> addNewVariety(@ApiParam(value = "Inventory Request Body") @RequestBody CoffeeRequestBody requestBody) {
        log.debug("add new coffee variety {}", requestBody);
        return getResponse(coffeeService.addNewVariety(requestBody), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get coffees status")
    @RequestMapping(value = "/coffee", method = RequestMethod.GET, params = "name")
    public ResponseEntity<List<CoffeeResponseBody>> getInventoryStatus(@ApiParam(value = "name")
                                                                       @RequestParam(value = "name") final String name) {
        log.debug("add new coffee variety for {} ", name);
        return getResponse(coffeeService.getInventoryStatus(name), HttpStatus.FOUND);
    }
}
