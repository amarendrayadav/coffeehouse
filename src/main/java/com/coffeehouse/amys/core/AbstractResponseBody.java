package com.coffeehouse.amys.core;

import lombok.Data;

import java.util.UUID;

@Data
public class AbstractResponseBody {
    private UUID id;

    public AbstractResponseBody(UUID id) {
        this.id = id != null ? id : UUID.fromString("00000000-0000-0000-0000-000000000000");
    }
}
