package com.nasser.providerservice.SMS.Controller;

import com.nasser.providerservice.SMS.Entity.SMS;
import com.nasser.providerservice.SMS.Service.ISMSProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sms")
public class SMSProviderController {

    @Qualifier("provider1Service")
    @Autowired
    private ISMSProvider provider1Service;

    @Qualifier("provider2Service")
    @Autowired
    private ISMSProvider provider2Service;

    @PostMapping
    public ResponseEntity<String> sendSMS(@RequestBody SMS sms, @RequestParam String provider) {
        String response;
        if ("provider1".equalsIgnoreCase(provider)) {
            response = provider1Service.sendSMS(sms);
        } else if ("provider2".equalsIgnoreCase(provider)) {
            response = provider2Service.sendSMS(sms);
        } else {
            return ResponseEntity.badRequest().body("Invalid provider specified");
        }
        return ResponseEntity.ok(response);
    }
}

