package com.nasser.providerservice.SMS.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SMS {
    private String phoneNumber;
    private String message;
    private String language;
}
