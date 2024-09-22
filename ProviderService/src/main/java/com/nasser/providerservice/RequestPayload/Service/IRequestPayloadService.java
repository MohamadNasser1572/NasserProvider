package com.nasser.providerservice.RequestPayload.Service;

import com.nasser.providerservice.RequestPayload.Entity.RequestPayload;

import java.util.List;

public interface IRequestPayloadService {
    RequestPayload create(RequestPayload payload);

    RequestPayload findById(Long id);

    List<RequestPayload> findAll();

    boolean deleteById(Long id);

    boolean updateRequestPayload(Long id, RequestPayload updatedPayload);


}
