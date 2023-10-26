package com.satc.architecture.account.paymentinfo;

import com.satc.architecture.account.paymentinfo.creditcard.CreditCardService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account/{idAccount}/payment-info")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PaymentInfoController {

    private PaymentInfoService paymentInfoService;
    private PaymentInfoFactory paymentInfoFactory;

//    private CreditCardService creditCardService;


    @PostMapping
    @RequestMapping("create")
    public ResponseEntity createNewAccountPayment(
           @Validated @RequestBody PaymentInfoRepresentation.CreatePaymentInfo createPaymentInfo) {

        PaymentInfoEntity paymentInfoEntity = PaymentInfoFactory.getPaymentInfoEntity(createPaymentInfo);
        return ResponseEntity.ok().build();
    }
}
