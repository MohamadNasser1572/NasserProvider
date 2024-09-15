package com.nasser.providerservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsRequestDTO {
    private String phoneNumber;
    private String message;
    private String language;
}
