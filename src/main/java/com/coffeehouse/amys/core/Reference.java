package com.coffeehouse.amys.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(NON_NULL)
@NoArgsConstructor
public class Reference extends AbstractEntity {
    @JsonView(Object.class)
    private String name;

    @JsonView(Object.class)
    private ObjectTypeEnum type;

    public Reference(final UUID id, final String name, final ObjectTypeEnum type) {
        super(id);
        this.name = name;
        this.type = type;
    }
}
