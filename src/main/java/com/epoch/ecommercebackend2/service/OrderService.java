package com.epoch.ecommercebackend2.service;

import com.epoch.ecommercebackend2.model.LocalUser;
import com.epoch.ecommercebackend2.model.WebOrder;
import com.epoch.ecommercebackend2.model.dao.WebOrderDAO;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }

    public List<WebOrder> getOrders(LocalUser user){
        return webOrderDAO.findByUser(user);
    }
}
