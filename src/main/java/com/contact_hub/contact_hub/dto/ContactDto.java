package com.contact_hub.contact_hub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// to reduce boiler plate but providing getters & setters for the class
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/*
 * A DTO (Data Transfer Object) is a plain Java object used to transfer data
 * between different layers of an application, particularly between the client
 * and the server. DTOs are not meant to contain any business logic. They are
 * simply containers for data that represent a specific piece of information,
 * formatted in a way that's convenient for the recipient.
 */

public class ContactDto {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
}