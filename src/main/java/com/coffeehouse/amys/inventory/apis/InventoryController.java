package com.coffeehouse.amys.inventory.apis;

import com.coffeehouse.amys.core.AbstractController;
import com.coffeehouse.amys.inventory.dataaccess.InventoryRequestBody;
import com.coffeehouse.amys.inventory.dataaccess.InventoryResponseBody;
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
public class InventoryController extends AbstractController {

    private final InventoryService inventoryService;

    @ApiOperation(value = "Get all from coffees")
    @RequestMapping(value = "/coffee", method = RequestMethod.GET)
    public ResponseEntity<List<InventoryResponseBody>> getInventoryStatus() {
        log.debug("get all from coffees ");
        return getResponse(inventoryService.getAllVarieties(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add new coffee variety")
    @RequestMapping(value = "/coffee", method = RequestMethod.POST)
    public ResponseEntity<InventoryResponseBody> addNewVariety(@ApiParam(value = "Inventory Request Body") @RequestBody InventoryRequestBody requestBody) {
        log.debug("add new coffee variety {}", requestBody);
        return getResponse(inventoryService.addNewVariety(requestBody), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get coffees status")
    @RequestMapping(value = "/coffee", method = RequestMethod.GET, params = "name")
    public ResponseEntity<List<InventoryResponseBody>> getInventoryStatus(@ApiParam(value = "name")
                                                                       @RequestParam(value = "name") final String name) {
        log.debug("add new coffee variety for {} ", name);
        return getResponse(inventoryService.getInventoryStatus(name), HttpStatus.FOUND);
    }
}
