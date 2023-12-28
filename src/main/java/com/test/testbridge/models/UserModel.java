package com.test.testbridge.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class UserModel {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    @Email
    private String email;
    @NotBlank
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
