package com.coffeehouse.amys.inventory.apis;

import com.coffeehouse.amys.inventory.dataaccess.CoffeeRepository;
import com.coffeehouse.amys.inventory.dataaccess.CoffeeRequestBody;
import com.coffeehouse.amys.inventory.dataaccess.CoffeeResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
@Slf4j
@RequiredArgsConstructor
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

/*    private final CoffeeResponseBody addNewVariety(final CoffeeRequestBody requestBody){
        log.debug("Request to add new variety {}", requestBody);
    }*/
}
