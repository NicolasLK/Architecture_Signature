package com.satc.architecture.account;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;
    private AccountRepository accountRepository;

    @PostMapping
    @RequestMapping("new-account")
    public ResponseEntity createNewAccont(
            @Validated @RequestBody AccountRepresentation.CreateAccount newAccount) {

        this.accountService.validadeBusiness(newAccount);

        AccountEntity newAccountEntity =
                this.accountService.createAccount(newAccount);

        return ResponseEntity.status(201)
                .body(AccountRepresentation.AccountResponse.from(newAccountEntity));
    }
}
