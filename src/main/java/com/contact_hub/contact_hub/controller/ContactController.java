package com.contact_hub.contact_hub.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import com.contact_hub.contact_hub.dto.ContactDto;
import com.contact_hub.contact_hub.service.ContactService;

//  POSTMAN/CLIENT => DTO => CONTROLLER LAYER => SERVICE LAYER => REPOSITORY LAYER => DB
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/contacts")

public class ContactController {
    private ContactService contactService;

    // Build ADD Contact REST API
    @PostMapping
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto) {
        ContactDto savedContact = contactService.createContact(contactDto);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    // Build GET Contact REST API
    @GetMapping
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<ContactDto> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    // Build GET SPECIFIC Contact REST API
    @GetMapping("{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable("id") Long contactId) {
        ContactDto contactDto = contactService.getContactById(contactId);
        return ResponseEntity.ok(contactDto);
    }

    // Build UPDATE Contact REST API
    @PutMapping("{id}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable("id") Long contactId,
                                                    @RequestBody ContactDto updatedContact) {
        ContactDto contactDto = contactService.updateContact(contactId, updatedContact);
        return ResponseEntity.ok(contactDto);
    }

    // Build DELETE Contact REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long contactId) {
        contactService.deleteContact(contactId);
        return ResponseEntity.ok("Contact deleted successfully");
    }

}
