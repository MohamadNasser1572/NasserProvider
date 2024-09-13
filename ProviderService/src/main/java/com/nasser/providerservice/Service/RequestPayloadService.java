package com.nasser.providerservice.Service;

import com.nasser.providerservice.Model.RequestPayload;

import java.util.List;

public interface RequestPayloadService {
    RequestPayload create(RequestPayload payload);

    RequestPayload findById(Long id);

    List<RequestPayload> findAll();

    boolean deleteById(Long id);

    boolean updateRequestPayload(Long id, RequestPayload updatedPayload);


}
