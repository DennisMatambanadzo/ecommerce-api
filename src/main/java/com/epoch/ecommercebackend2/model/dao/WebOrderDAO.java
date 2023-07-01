package com.epoch.ecommercebackend2.model.dao;

import com.epoch.ecommercebackend2.model.LocalUser;
import com.epoch.ecommercebackend2.model.WebOrder;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WebOrderDAO extends ListCrudRepository<WebOrder,Long> {
    List<WebOrder> findByUser(LocalUser user);

}
