package com.epoch.ecommercebackend2.model.dao;

import com.epoch.ecommercebackend2.model.VerificationToken;
import org.springframework.data.repository.ListCrudRepository;

public interface VerificationTokenDAO extends ListCrudRepository<VerificationToken, Long> {
}
