package com.tyss.dockerimplementation.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {

    private int statusCode;
    private long responseTime;
    private String message;
    private T data;
}
