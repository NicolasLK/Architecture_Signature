package com.satc.architecture.account;

import com.satc.architecture.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    /**
     * validate business integrity
     * @param newAccount
     */
    public void validadeBusiness(AccountRepresentation.CreateAccount newAccount) {

        if (!newAccount.getPassword().equals(newAccount.getPasswordConfirmation())) {
            throw new BusinessException("A senha e a confirmação não são iguais!");
        }

        String email =
                this.accountRepository.validateEmail(newAccount.getEmail());
        if(!Objects.isNull(email)) {
            throw new BusinessException("O email já esta sendo usado");
        }

        String userName =
                this.accountRepository.validateUserName(newAccount.getEmail());
        if(!Objects.isNull(userName) && !userName.isEmpty()) {
            throw new BusinessException("O userName já esta sendo usado");
        }
    }

    public AccountEntity createAccount(AccountRepresentation.CreateAccount newAccount) {

        return this.accountRepository.save(AccountEntity.builder()
                .name(newAccount.getName())
                .document(newAccount.getDocument())
                .email(newAccount.getEmail())
                .userName(newAccount.getUserName())
                .password(newAccount.getPassword())
                .build());
    }
}
