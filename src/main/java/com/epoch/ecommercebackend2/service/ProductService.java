package com.epoch.ecommercebackend2.service;

import com.epoch.ecommercebackend2.model.Product;
import com.epoch.ecommercebackend2.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    /**
     * Constructor for spring injection.
     * @param productDAO
     */
    private ProductDAO productDAO;


    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    /**
     * Gets the all products available.
     * @return The list of products.
     */
    public List<Product> getProducts(){
        return productDAO.findAll();
    }
}
