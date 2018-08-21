package com.coffeehouse.amys.core;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class AbstractEntity {
    @Id
    private UUID _id;
}
