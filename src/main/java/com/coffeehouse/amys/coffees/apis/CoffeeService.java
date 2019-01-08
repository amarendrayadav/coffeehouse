package com.coffeehouse.amys.coffees.apis;

import com.coffeehouse.amys.coffees.adapter.CoffeeAdapter;
import com.coffeehouse.amys.coffees.dataaccess.Coffee;
import com.coffeehouse.amys.coffees.dataaccess.CoffeeRepository;
import com.coffeehouse.amys.coffees.dataaccess.CoffeeRequestBody;
import com.coffeehouse.amys.coffees.dataaccess.CoffeeResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@RequiredArgsConstructor
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeResponseBody addNewVariety(final CoffeeRequestBody requestBody) {
        log.debug("Request to add new variety {}", requestBody);
        final Coffee coffee = coffeeRepository.save(CoffeeAdapter.convertRequest(requestBody));
        log.debug("saved new variety {} ", coffee);
        return CoffeeAdapter.convertEntity(coffee);
    }

    public List<CoffeeResponseBody> getInventoryStatus(final String name) {
        log.debug("getting status for {} ", name);
        return coffeeRepository.getAllByNameLike(name).stream().map(CoffeeAdapter::convertEntity).collect(toList());
    }

    public List<CoffeeResponseBody> getAllVarieties() {
        log.debug("getting all coffee varieties");
        return coffeeRepository.findAll().stream().map(CoffeeAdapter::convertEntity).collect(toList());
    }
}
