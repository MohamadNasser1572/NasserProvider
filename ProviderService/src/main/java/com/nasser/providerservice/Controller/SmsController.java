package com.nasser.providerservice.Controller;

import com.nasser.providerservice.Service.impl.Provider1ServiceImpl;
import com.nasser.providerservice.Entity.SMS;
import com.nasser.providerservice.Service.impl.Provider2ServiceImpl;
import com.nasser.providerservice.Service.impl.Provider3ServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SmsController {


    private final Provider1ServiceImpl provider1ServiceImpl;
    private final Provider2ServiceImpl provider2ServiceImpl;
    private final Provider3ServiceImpl provider3ServiceImpl;

    public SmsController(Provider1ServiceImpl provider1ServiceImpl, Provider2ServiceImpl provider2ServiceImpl, Provider3ServiceImpl provider3ServiceImpl) {
        this.provider1ServiceImpl = provider1ServiceImpl;
        this.provider2ServiceImpl = provider2ServiceImpl;
        this.provider3ServiceImpl = provider3ServiceImpl;
    }

    @PostMapping("/provider1/sms")
    public ResponseEntity<String> sendSMSProvider1(@RequestBody SMS sms) {
        provider1ServiceImpl.sendSMS(sms);
        return ResponseEntity.ok("SMS sent for Provider 1");
    }

    @PostMapping("/provider2/sms")
    public ResponseEntity<String> sendSMSProvider2(@RequestBody SMS sms) {
        provider2ServiceImpl.sendSMS(sms);
        return ResponseEntity.ok("SMS sent for Provider 2");
    }

    @PostMapping("/provider3/sms")
    public ResponseEntity<String> sendSMSProvider3(@RequestBody SMS sms) {
        provider3ServiceImpl.sendSMS(sms);
        return ResponseEntity.ok("SMS sent for Provider 3");
    }
}
