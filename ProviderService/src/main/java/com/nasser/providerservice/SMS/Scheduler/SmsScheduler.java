package com.nasser.providerservice.SMS.Scheduler;

import com.nasser.providerservice.Provider.Service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SmsScheduler {
    @Autowired
    private IProviderService IProviderService;

    @Scheduled(fixedRate = 30000)//milliseconds
    public void sendScheduledSms() {
        IProviderService.sendScheduledSms();
    }
}
