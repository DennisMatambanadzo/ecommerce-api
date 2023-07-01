package com.epoch.ecommercebackend2.service;

import com.epoch.ecommercebackend2.api.model.RegistrationBody;
import com.epoch.ecommercebackend2.api.model.dao.LocalUserDAO;
import com.epoch.ecommercebackend2.exception.UserAlreadyExistsException;
import com.epoch.ecommercebackend2.model.LocalUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody)throws UserAlreadyExistsException {
        if( localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() ||
                localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        //TODO:Encrypt Passwords!!
        user.setPassword(registrationBody.getPassword());
       return localUserDAO.save(user);

    }
}
