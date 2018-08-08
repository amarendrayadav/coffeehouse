package com.coffeehouse.amys.core;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractController {
    private <T> ResponseEntity<T> buildResponseEntity(T entity, HttpHeaders httpHeaders, HttpStatus status) {
        if (httpHeaders == null) {
            httpHeaders = new HttpHeaders();
        }
        httpHeaders.setAccessControlMaxAge(86400L);
        return new ResponseEntity(entity, httpHeaders, status);
    }

    protected <T> ResponseEntity<T> getResponse(T entity, HttpStatus status) {
        return this.buildResponseEntity(entity, (HttpHeaders) null, status);
    }

    protected <T> ResponseEntity<T> getResponse(HttpStatus status) {
        return this.buildResponseEntity(null, (HttpHeaders) null, status);
    }
}
