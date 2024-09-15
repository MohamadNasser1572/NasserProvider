package com.nasser.providerservice.Controller;

import com.nasser.providerservice.Entity.RequestPayload;
import com.nasser.providerservice.Service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProviderController {

    @Autowired
    private IProviderService IProviderService;

    @GetMapping("/GETprovider1")
    public String getProvider1(@RequestParam Long phoneNumber, @RequestParam String message) {
        return IProviderService.getProvider1(phoneNumber, message);
    }

    @PostMapping("/POSTprovider2")
    public String postProvider2(@RequestBody RequestPayload requestPayload) {
        return IProviderService.postProvider2(requestPayload);
    }
}
