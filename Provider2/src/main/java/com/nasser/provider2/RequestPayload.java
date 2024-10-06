package com.nasser.provider2;
//create a payload class to understand the request of the sent info from json

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPayload {
    private Long phoneNumber;
    private String message;
    private String language;
}
