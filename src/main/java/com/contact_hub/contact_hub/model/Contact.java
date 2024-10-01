package com.contact_hub.contact_hub.model;
import  jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

// lombok getter & setters to reduce the boiler plate codes
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// Marks this class as a JPA entity that maps to a database table.
@Entity

// To specify the table details
@Table(name = "contacts")
@Builder
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // to automatically increment the primary key
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "Email")
    private String email;
}