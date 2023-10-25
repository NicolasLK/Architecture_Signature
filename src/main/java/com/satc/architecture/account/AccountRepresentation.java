package com.satc.architecture.account;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface AccountRepresentation {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class CreateAccount {
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

        @NotNull(message = "A confirmação não pode ser nulo")
        @NotEmpty(message = "A confirmação não pode ser vazio")
        private String passwordConfirmation;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class AccountResponse {
        private Long id;
        private String name;
        private String email;
        private String userName;

        public static AccountResponse from(AccountEntity account){
            return AccountResponse.builder()
                    .id(account.getId())
                    .userName(account.getUserName())
                    .name(account.getName())
                    .email(account.getEmail())
                    .build();
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class PaymentInfo {
        private String cardNumber;
        private String cardHolder;
        private String cardCvv;
        private String expirationDate;
    }
}
