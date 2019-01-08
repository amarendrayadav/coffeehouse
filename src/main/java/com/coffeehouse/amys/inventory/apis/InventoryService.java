package com.coffeehouse.amys.inventory.apis;

import com.coffeehouse.amys.inventory.adapter.InventoryAdapter;
import com.coffeehouse.amys.inventory.dataaccess.Inventory;
import com.coffeehouse.amys.inventory.dataaccess.InventoryRepository;
import com.coffeehouse.amys.inventory.dataaccess.InventoryRequestBody;
import com.coffeehouse.amys.inventory.dataaccess.InventoryResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryResponseBody addNewVariety(final InventoryRequestBody requestBody) {
        log.debug("Request to add new variety {}", requestBody);
        final Inventory inventory = inventoryRepository.save(InventoryAdapter.convertRequest(requestBody));
        log.debug("saved new variety {} ", inventory);
        return InventoryAdapter.convertEntity(inventory);
    }

    public List<InventoryResponseBody> getInventoryStatus(final String name) {
        log.debug("getting status for {} ", name);
        return inventoryRepository.getAllByNameLike(name).stream().map(InventoryAdapter::convertEntity).collect(toList());
    }

    public List<InventoryResponseBody> getAllVarieties() {
        log.debug("getting all coffee varieties");
        return inventoryRepository.findAll().stream().map(InventoryAdapter::convertEntity).collect(toList());
    }
}
