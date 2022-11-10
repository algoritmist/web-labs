package org.algoritmist.weblabs.lab2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class Response {
    /*private Result result;
    private String currentTime;
    private String workingTime;*/
    public Result result;
    public String currentTime;
    public String workingTime;

    public Response() {
        currentTime = workingTime = "0";
    }
}
