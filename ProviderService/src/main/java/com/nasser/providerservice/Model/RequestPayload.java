package com.nasser.providerservice.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//put getters for deserialization
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class RequestPayload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long phoneNumber;
    private String message;
    private String language;
}