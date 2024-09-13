package com.nasser.providerservice.Controller;


import com.nasser.providerservice.DTO.SmsRequestDTO;
import com.nasser.providerservice.Service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    private SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/api/sms")
    public String sendSms(@RequestBody SmsRequestDTO smsRequestDTO) {
        return smsService.sendSms(smsRequestDTO);
    }
}
