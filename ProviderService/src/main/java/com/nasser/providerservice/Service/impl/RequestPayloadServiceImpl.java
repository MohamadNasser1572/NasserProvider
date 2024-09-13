package com.nasser.providerservice.Service.impl;

import com.nasser.providerservice.Model.RequestPayload;
import com.nasser.providerservice.Repository.RequestPayloadRepository;
import com.nasser.providerservice.Service.RequestPayloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestPayloadServiceImpl implements RequestPayloadService {

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
    public void deleteById(Long id) {
        requestPayloadRepository.deleteById(id);
    }
}
