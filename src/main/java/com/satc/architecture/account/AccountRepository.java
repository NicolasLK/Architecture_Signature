package com.satc.architecture.account;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    @Query(value = "Select email from AccountEntity where email = ?1")
    String validateEmail(String value);

    @Query(value = "Select userName from AccountEntity where userName = 1?")
    String validateUserName(String value);
}
