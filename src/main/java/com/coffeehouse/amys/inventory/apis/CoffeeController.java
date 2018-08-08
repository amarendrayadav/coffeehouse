package com.coffeehouse.amys.inventory.apis;

import com.coffeehouse.amys.core.AbstractController;
import com.coffeehouse.amys.inventory.dataaccess.CoffeeRequestBody;
import com.coffeehouse.amys.inventory.dataaccess.CoffeeResponseBody;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inventory")
@Slf4j
@RequiredArgsConstructor
public class CoffeeController extends AbstractController {
    private final CoffeeService coffeeService;

    @ApiOperation(value = "Add new coffee variety")
    @RequestMapping(value = "/coffee", method = RequestMethod.POST)
    public ResponseEntity<CoffeeResponseBody> addNewVariety(@RequestBody CoffeeRequestBody requestBody) {
        log.debug("add new coffee variety {}", requestBody);
        return null;
    }

    @ApiOperation(value = "Get inventory status")
    @RequestMapping(value = "/coffee", method = RequestMethod.GET, params = "name")
    public ResponseEntity<CoffeeResponseBody> getInventoryStatus(@ApiParam(value = "name")
                                                                 @RequestParam(value = "name") final String name) {
        log.debug("add new coffee variety for {} ", name);
        return null;
    }
}
