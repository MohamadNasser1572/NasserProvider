package com.nasser.providerservice.RequestPayload.Service.impl;

import com.nasser.providerservice.RequestPayload.Entity.RequestPayload;
import com.nasser.providerservice.RequestPayload.Repository.RequestPayloadRepository;
import com.nasser.providerservice.RequestPayload.Service.IRequestPayloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestPayloadServiceImpl implements IRequestPayloadService {

    @Autowired
    private RequestPayloadRepository requestPayloadRepository;

    @Override
    public RequestPayload create(RequestPayload payload) {
        return requestPayloadRepository.save(payload);
    }

    @Override
    public RequestPayload findById(Long id) {
        return requestPayloadRepository.findById(id).orElse(null);
    }

    @Override
    public List<RequestPayload> findAll() {
        return requestPayloadRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            requestPayloadRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateRequestPayload(Long id, RequestPayload updatedPayload) {
        Optional<RequestPayload> payloadOptional = requestPayloadRepository.findById(id);
        if (payloadOptional.isPresent()) {
            RequestPayload payload = payloadOptional.get();
            payload.setPhoneNumber(updatedPayload.getPhoneNumber());
            payload.setMessage(updatedPayload.getMessage());
            payload.setLanguage(updatedPayload.getLanguage());
            requestPayloadRepository.save(payload);
            return true;
        }
        return false;
    }


}
