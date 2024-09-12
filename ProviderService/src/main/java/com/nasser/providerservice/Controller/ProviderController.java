package com.nasser.providerservice.Controller;

import com.nasser.providerservice.Model.RequestPayload;
import com.nasser.providerservice.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;

@RestController
@RequestMapping("/api")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/GETprovider1")
    public String getProvider1(@RequestParam Long phoneNumber, @RequestParam String message) {
        return providerService.getProvider1(phoneNumber, message);
    }

    @PostMapping("/POSTprovider2")
    public String postProvider2(@RequestBody RequestPayload requestPayload) {
        return providerService.postProvider2(requestPayload);
    }
}
