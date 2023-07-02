package com.epoch.ecommercebackend2.model.dao;

import com.epoch.ecommercebackend2.model.LocalUser;
import com.epoch.ecommercebackend2.model.VerificationToken;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface VerificationTokenDAO extends ListCrudRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);

    void deleteByUser(LocalUser user);
}
