package by.dzhivushko.training.shop.service;

import java.util.List;

import by.dzhivushko.training.shop.dataaccess.filters.ProductFilter;
import by.dzhivushko.training.shop.datamodel.Product;

public interface ProductService {

    Long count(ProductFilter filter);

    List<Product> find(ProductFilter filter);
}
