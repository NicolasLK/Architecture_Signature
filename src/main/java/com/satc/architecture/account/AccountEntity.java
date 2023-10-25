package com.satc.architecture.account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo")
    @NotEmpty(message = "O nome não pode ser vazio")
    private String name;
    @NotNull(message = "O email não pode ser nulo")
    @NotEmpty(message = "O email não pode ser vazio")
    private String email;
    @NotNull(message = "O document não pode ser nulo")
    @NotEmpty(message = "O document não pode ser vazio")
    private String document;

    @NotNull(message = "O usuário não pode ser nulo")
    @NotEmpty(message = "O usuário não pode ser vazio")
    private String userName;

    @NotNull(message = "A senha não pode ser nulo")
    @NotEmpty(message = "A senha não pode ser vazio")
    private String password;
}
