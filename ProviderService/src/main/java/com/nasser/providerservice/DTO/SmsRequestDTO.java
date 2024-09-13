package com.nasser.providerservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsRequestDTO {
    private String recipientPhoneNumber;
    private String message;
}
