package com.epoch.ecommercebackend2.model.dao;

import com.epoch.ecommercebackend2.model.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<Product,Long> {
}
