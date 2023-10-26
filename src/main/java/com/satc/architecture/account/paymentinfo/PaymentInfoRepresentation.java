package com.satc.architecture.account.paymentinfo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public interface PaymentInfoRepresentation {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class CreatePaymentInfo {

        @NotNull
        private PaymentType paymentType;

        @Valid
        private CreateCreditCardInfo creditCard;

        @Valid
        private CreateBankSlipInfo bankSlip;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class CreateCreditCardInfo {
        @NotNull
        @NotEmpty
        private String cardHolder;

        @NotNull
        @NotEmpty
        private String cardNumber;

        @NotNull
        @NotEmpty
        private String cardCvv;

        @NotNull
//        @NotEmpty
        private LocalDate expirationDate;
    }
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class CreateBankSlipInfo {
        @NotNull(message = "O nome não pode ser nulo")
        @NotEmpty(message = "O nome não pode ser vazio")
        private String name;

        @NotNull(message = "O email não pode ser nulo")
        @NotEmpty(message = "O email não pode ser vazio")
        private String email;

        @NotNull(message = "O document não pode ser nulo")
        @NotEmpty(message = "O document não pode ser vazio")
        private String document;
    }
}
