package com.nasser.providerservice.Model;


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

    //put getters for deserialization
}