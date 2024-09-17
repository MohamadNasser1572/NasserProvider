package com.nasser.provider2.Controller;

import com.nasser.provider2.RequestPayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider2Controller {

    @PostMapping("/provider2/sms")
    public String postProvider2(@RequestBody RequestPayload requestPayload) {
        System.out.println("POST working");
        // Deserialization
        return "POST working with phoneNumber " + requestPayload.getPhoneNumber()
                + ", message " + requestPayload.getMessage()
                + " and language " + requestPayload.getLanguage();
    }
}
