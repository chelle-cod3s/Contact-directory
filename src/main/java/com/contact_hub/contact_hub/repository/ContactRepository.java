package com.contact_hub.contact_hub.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.contact_hub.contact_hub.model.Contact;

/*
 * A Repository in Spring Boot is a central mechanism that encapsulates the logic required
 * to access data sources. It abstracts the data access layer, allowing you to
 * interact with databases in a cleaner and more maintainable way. Repositories
 * are part of the Spring Data JPA framework, which simplifies
 * data access using JPA (Java Persistence API).
 *
 * CRUD Operations:
 * Spring Data JPA repositories come with built-in methods
 * for common CRUD (Create, Read, Update, Delete) operations,
 * such as save(), findById(), findAll(), and delete().
 */
// allows you to perform CRUD on the model
// JpaRepository accepts the model and the type of the primary key as parameters
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
