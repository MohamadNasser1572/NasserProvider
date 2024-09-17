package com.nasser.providerservice.Repository;

import com.nasser.providerservice.Entity.RequestPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestPayloadRepository extends JpaRepository<RequestPayload, Long> {
}
