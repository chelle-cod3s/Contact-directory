package com.contact_hub.contact_hub.service;

import java.util.List;

import com.contact_hub.contact_hub.dto.ContactDto;

/*
 * In a Spring Boot application, the service package is used to contain the service
 * layer of the application. The service layer acts as a bridge
 * between the controller (which handles HTTP requests and user input)
 * and the repository (which directly interacts with the database).
 * It is responsible for implementing business logic, ensuring data integrity,
 * and managing data processing tasks.
 *
 * POSTMAN/CLIENT => DTO => CONTROLLER LAYER => SERVICE LAYER => REPOSITORY LAYER => DB
 */

public interface ContactService {
    ContactDto createContact(ContactDto contactDto);

    ContactDto getContactById(Long contactId);

    List<ContactDto> getAllContacts();

    ContactDto updateContact(Long contactId, ContactDto updatedContact);

    void deleteContact(Long contactId);
}