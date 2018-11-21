package com.coffeehouse.amys.customer.apis;

import com.coffeehouse.amys.core.AbstractController;
import com.coffeehouse.amys.customer.dataaccess.CustomerRequestBody;
import com.coffeehouse.amys.customer.dataaccess.CustomerResponseBody;
import com.coffeehouse.amys.customer.validator.CustomerRequestBodyValidator;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping(value = "/coffeehouse")
@Slf4j
@RequiredArgsConstructor
public class CustomerController extends AbstractController {

    private final CustomerService customerService;
    private final CustomerRequestBodyValidator customerRequestBodyValidator;

    @InitBinder
    public void dataBindings(final WebDataBinder binder,
                             final HttpServletRequest request) {
        final Object target = binder.getTarget();
        if (nonNull(target)) {
            if (CustomerRequestBody.class.equals(target.getClass())) {
                binder.addValidators(customerRequestBodyValidator);
            }
        }
    }

    @ApiOperation(value = "Add new customer")
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<CustomerResponseBody> addNewCustomer(@RequestBody CustomerRequestBody requestBody) {
        log.debug("Request to add new customer {} ", requestBody);
        final CustomerResponseBody customerResponseBody = customerService.addNewCustomer(requestBody);
        log.debug("New Customer {} ", customerResponseBody);
        return getResponse(customerResponseBody, HttpStatus.OK);
    }


    @ApiOperation(value = "Get customer by phoneNumber ")
    @RequestMapping(value = "/customer", method = RequestMethod.GET, params = "phoneNumber")
    public ResponseEntity<CustomerResponseBody> getCustomerByPhoneNumber(@RequestParam(value = "phoneNumber") final String phoneNumber) {
        log.debug("Request to get customer by phoneNumber {} ", phoneNumber);
        final CustomerResponseBody customerResponseBody = customerService.getCustomerByPhone(phoneNumber);
        return getResponse(customerResponseBody, HttpStatus.OK);
    }


    @ApiOperation(value = "Get customer by name ")
    @RequestMapping(value = "/customer", method = RequestMethod.GET, params = "name")
    public ResponseEntity<CustomerResponseBody> getCustomerByName(@RequestParam(value = "name") final String name) {
        log.debug("Request to get customer by name {} ", name);
        return getResponse(customerService.getCustomerByName(name), HttpStatus.OK);
    }
}
