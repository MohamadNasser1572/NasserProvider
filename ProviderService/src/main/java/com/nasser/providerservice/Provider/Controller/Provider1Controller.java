package com.nasser.providerservice.Provider.Controller;

import com.nasser.providerservice.SMS.Entity.SMS;
import com.nasser.providerservice.SMS.Service.ISMSProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider1/sms")
public class Provider1Controller {


    private final ISMSProvider smsProvider;

    @Autowired
    public Provider1Controller(@Qualifier("provider1Service") ISMSProvider smsProvider) {
        this.smsProvider = smsProvider;
    }

    @PostMapping
    public ResponseEntity<String> sendSMS(@RequestBody SMS request) {
        boolean result = Boolean.parseBoolean(smsProvider.sendSMS(request));
        if (result) {
            return ResponseEntity.ok("SMS sent successfully via Provider1");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send SMS via Provider1");
        }
    }
}

