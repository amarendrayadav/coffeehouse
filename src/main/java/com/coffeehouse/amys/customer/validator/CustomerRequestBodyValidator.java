package com.coffeehouse.amys.customer.validator;

import com.coffeehouse.amys.customer.dataaccess.CustomerRequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static java.util.Objects.isNull;

@Slf4j
@Component
public class CustomerRequestBodyValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        final CustomerRequestBody requestBody = (CustomerRequestBody) object;
        if (isNull(requestBody.getPhoneNumber())) {
            errors.rejectValue("customer.phoneNumber", "error.validation.customerRequestBody.phoneNumber.empty");
        }
    }
}
