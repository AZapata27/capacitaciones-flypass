package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.Post;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "complex_users")
public class ComplexUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String firstName;
    private String lastName;

    @Column(length = 15)
    private String phoneNumber;

    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    private LocalDate dateOfBirth;
    private String gender; // e.g., "Male", "Female", "Non-Binary", etc.

    private String profilePictureUrl;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private List<String> roles; // e.g., "USER", "ADMIN", etc.

    private boolean active;


    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Product> products;

    // Otros campos de interés personal
    private String bio;
    private String websiteUrl;

    // Campos relacionados con la seguridad
    private int failedLoginAttempts;
    private LocalDateTime lastLoginDate;
    private LocalDateTime passwordChangedDate;

    // Preferencias del usuario
    private String preferredLanguage; // e.g., "en", "es", etc.
    private String timezone; // e.g., "UTC", "America/New_York", etc.

    // Información de verificación
    private boolean emailVerified;
    private boolean phoneVerified;

}
