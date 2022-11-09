package org.algoritmist.weblabs.lab2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Response {
    private Result result;
    private String currentTime;
    private String workingTime;
}
