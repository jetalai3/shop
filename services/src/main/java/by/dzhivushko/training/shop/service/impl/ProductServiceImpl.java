package by.dzhivushko.training.shop.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import by.dzhivushko.training.shop.dataaccess.ProductDao;
import by.dzhivushko.training.shop.service.ProductService;
import by.dzhivushko.training.shop.service.UserService;

@Service
public class ProductServiceImpl implements ProductService {

    @Inject
    private ProductDao dao;

    @Inject
    private UserService userService;

}
