package com.contact_hub.contact_hub.service.Impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import com.contact_hub.contact_hub.dto.ContactDto;
import com.contact_hub.contact_hub.exception.ResourceNotFoundException;
import com.contact_hub.contact_hub.mapper.ContactMapper;
import com.contact_hub.contact_hub.model.Contact;
import com.contact_hub.contact_hub.repository.ContactRepository;
import com.contact_hub.contact_hub.service.ContactService;

/*
 * POSTMAN/CLIENT => DTO => CONTROLLER LAYER => SERVICE LAYER => REPOSITORY LAYER => DB
 */


@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Override
    public ContactDto createContact(ContactDto contactDto) {

        // convert ContactDto to Contact model
        Contact contact = ContactMapper.mapToContact(contactDto);
        // save contact to the database
        Contact savedContact = contactRepository.save(contact);
        // return the bean data / JSON to the client
        return ContactMapper.mapToContactDto(savedContact);
    }

    @Override
    public ContactDto getContactById(Long contactId) {
        Contact contact = contactRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Contact with the id " + contactId + " does not exists"));
        return ContactMapper.mapToContactDto(contact);
    }

    @Override
    public List<ContactDto> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map((contact) -> ContactMapper.mapToContactDto(contact)).collect(Collectors.toList());
    }

    @Override
    public ContactDto updateContact(Long contactId, ContactDto updatedContact) {
        Contact contact = contactRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Contact with the id " + contactId + " does not exists"));

        contact.setFullName(updatedContact.getFullName());
        contact.setPhoneNumber(updatedContact.getPhoneNumber());
        contact.setEmail(updatedContact.getEmail());
        ;

        Contact updatedContactObj = contactRepository.save(contact);

        return ContactMapper.mapToContactDto(updatedContactObj);
    }

    @Override
    public void deleteContact(Long contactId) {
        contactRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Contact with the given ID does not exists" + contactId));

        contactRepository.deleteById(contactId);
    }
}
