package com.epoch.ecommercebackend2.service;

import com.epoch.ecommercebackend2.model.Product;
import com.epoch.ecommercebackend2.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDAO productDAO;


    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getProducts(){
        return productDAO.findAll();
    }
}
