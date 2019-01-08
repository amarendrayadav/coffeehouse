package com.coffeehouse.amys.core;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AbstractEntity {
    @Id
    private UUID _id;

    public AbstractEntity(UUID id) {
        this._id = id != null ? id : UUID.fromString("00000000-0000-0000-0000-000000000000");
    }
}
