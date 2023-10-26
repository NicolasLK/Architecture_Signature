package com.satc.architecture.account.paymentinfo;

public class PaymentInfoFactory {

    public static PaymentInfoEntity getPaymentInfoEntity(
            PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {

        return switch (createPaymentInfo.getPaymentType()) {
            case BANK_SLIP -> buidBankSlip(createPaymentInfo);
            default -> buidCreditCart(createPaymentInfo);

        };
    }

    private static PaymentInfoEntity buidCreditCart(PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {
        return PaymentInfoEntity.builder().build();
    }

    private static PaymentInfoEntity buidBankSlip(PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {
        return PaymentInfoEntity.builder().build();
    }
}
