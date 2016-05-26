package by.dzhivushko.training.shop.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import by.dzhivushko.training.shop.dataaccess.ProductDao;
import by.dzhivushko.training.shop.dataaccess.filters.ProductFilter;
import by.dzhivushko.training.shop.datamodel.Product;
import by.dzhivushko.training.shop.service.ProductService;
import by.dzhivushko.training.shop.service.UserService;

@Service
public class ProductServiceImpl implements ProductService {

    @Inject
    private ProductDao dao;

    @Inject
    private UserService userService;

    @Override
    public Long count(ProductFilter filter) {
        return dao.count(filter);
    }

    @Override
    public List<Product> find(ProductFilter filter) {
        return dao.find(filter);
    }
}
