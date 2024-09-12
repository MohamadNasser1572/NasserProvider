package com.nasser.providerservice.Scheduler;

import com.nasser.providerservice.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SmsScheduler {
    @Autowired
    private ProviderService providerService;

    @Scheduled(fixedRate = 30000)//milliseconds
    public void sendScheduledSms() {
        providerService.sendScheduledSms();
    }
}
