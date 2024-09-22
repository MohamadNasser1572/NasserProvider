package com.nasser.providerservice.RequestPayload.Controller;


import com.nasser.providerservice.RequestPayload.Entity.RequestPayload;
import com.nasser.providerservice.RequestPayload.Service.IRequestPayloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requestPayload")
public class RequestPayloadController {

    @Autowired
    private IRequestPayloadService IRequestPayloadService;

    @PostMapping
    public ResponseEntity<String> createRequestPayload(@RequestBody RequestPayload payload) {
        IRequestPayloadService.create(payload);
        return new ResponseEntity<>("Payload created Successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestPayload> getRequestPayloadById(@PathVariable Long id) {
        RequestPayload payload = IRequestPayloadService.findById(id);
        if (payload != null) {
            return ResponseEntity.ok(payload);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRequestPayload(@PathVariable Long id, @RequestBody RequestPayload updatedPayload) {
        boolean isUpdated = IRequestPayloadService.updateRequestPayload(id, updatedPayload);
        if (isUpdated) {
            return ResponseEntity.ok("RequestPayload updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RequestPayload not found.");
        }
    }

    @GetMapping
    public ResponseEntity<List<RequestPayload>> findAll() {
        return ResponseEntity.ok(IRequestPayloadService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteRequestPayloadById(@PathVariable Long id) {
        boolean deleted = IRequestPayloadService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>("Payload deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Payload not found", HttpStatus.NOT_FOUND);
    }
}
