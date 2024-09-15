package com.nasser.providerservice.Service;

import com.nasser.providerservice.Entity.SMS;

public interface ISMSProvider {
    String sendSMS(SMS sms);
}

