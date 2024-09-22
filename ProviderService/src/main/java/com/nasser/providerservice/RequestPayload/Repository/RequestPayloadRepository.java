package com.nasser.providerservice.RequestPayload.Repository;

import com.nasser.providerservice.RequestPayload.Entity.RequestPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestPayloadRepository extends JpaRepository<RequestPayload, Long> {
}
