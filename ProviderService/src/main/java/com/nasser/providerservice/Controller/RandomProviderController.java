package com.nasser.providerservice.Controller;

import com.nasser.providerservice.Entity.SMS;
import com.nasser.providerservice.Exception.RandomProviderException;
import com.nasser.providerservice.Service.ISMSProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/randomProvider/sms")
public class RandomProviderController {

    private final ISMSProvider provider1Service;
    private final ISMSProvider provider2Service;

    @Autowired
    public RandomProviderController(@Qualifier("provider1Service") ISMSProvider provider1Service,
                                    @Qualifier("provider2Service") ISMSProvider provider2Service) {
        this.provider1Service = provider1Service;
        this.provider2Service = provider2Service;
    }

    @PostMapping
    public ResponseEntity<String> sendSMSRandom(@RequestBody SMS request) {
        Random random = new Random();
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                provider1Service.sendSMS(request);
                return ResponseEntity.ok("SMS sent via Provider 1");
            case 1:
                provider2Service.sendSMS(request);
                return ResponseEntity.ok("SMS sent via Provider 2");
            default:
                throw new RandomProviderException("Random failure occurred!");
        }
    }
}
