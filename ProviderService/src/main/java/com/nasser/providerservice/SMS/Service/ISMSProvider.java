package com.nasser.providerservice.SMS.Service;

import com.nasser.providerservice.SMS.Entity.SMS;

public interface ISMSProvider {
    String sendSMS(SMS sms);
}

