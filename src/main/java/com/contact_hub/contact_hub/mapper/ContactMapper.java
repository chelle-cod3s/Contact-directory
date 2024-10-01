package com.contact_hub.contact_hub.mapper;

import com.contact_hub.contact_hub.model.Contact;
import com.contact_hub.contact_hub.dto.ContactDto;

/*
 * The purpose of this class is to convert (or "map")
 * between two different types of objects: Contact (the entity/model)
 * and ContactDto (the Data Transfer Object).
 * This mapping process helps to keep different layers of the
 *  application separate and allows you to control what data is
 * exposed to other parts of your application.
 *
 * Contact: main data model, which represents a contact stored in the database.
 * It probably has more fields and is directly linked to the database.
 *
 * ContactDto: This is a simplified version of Contact. It’s a Data Transfer
 * Object that usually contains only the necessary data you want to send back to clients
 * (e.g., when using a REST API).
 */

public class ContactMapper {
    public static ContactDto mapToContactDto(Contact contact) {
        return new ContactDto(
                contact.getId(),
                contact.getFullName(),
                contact.getPhoneNumber(),
                contact.getEmail());
    }

    public static Contact mapToContact(ContactDto contactDto) {
        return new Contact(
                contactDto.getId(), 
                contactDto.getFullName(),
                contactDto.getPhoneNumber(),
                contactDto.getEmail());
    }
}