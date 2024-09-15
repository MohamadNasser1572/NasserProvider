package com.nasser.providerservice.Controller;

import com.nasser.providerservice.Entity.SMS;
import com.nasser.providerservice.Service.ISMSProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider2/sms")
public class Provider2Controller {

    private final ISMSProvider smsProvider;

    @Autowired
    public Provider2Controller(@Qualifier("provider2Service") ISMSProvider smsProvider) {
        this.smsProvider = smsProvider;
    }

    @PostMapping
    public ResponseEntity<String> sendSMS(@RequestBody SMS request) {
        String result = smsProvider.sendSMS(request);
        if ("true".equalsIgnoreCase(result)) {
            return ResponseEntity.ok("SMS sent successfully via Provider2");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send SMS via Provider2");
        }
    }
}
