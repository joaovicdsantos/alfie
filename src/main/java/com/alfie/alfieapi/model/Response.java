package com.alfie.alfieapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.RepresentationModel;

@Primary
@Data
@EqualsAndHashCode(callSuper = true)
public class Response<T> extends RepresentationModel<Response<T>> {

    private int status;
    private T data;
    private Long timestamp;

    public Response() {
        this.timestamp = System.currentTimeMillis();
        this.status = 200;
    }

}
