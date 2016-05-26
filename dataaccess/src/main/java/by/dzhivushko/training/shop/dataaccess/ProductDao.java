package by.dzhivushko.training.shop.dataaccess;

import java.util.List;

import by.dzhivushko.training.shop.dataaccess.filters.ProductFilter;
import by.dzhivushko.training.shop.datamodel.Product;

public interface ProductDao extends AbstractDao<Product, Long> {

    Long count(ProductFilter filter);

    List<Product> find(ProductFilter filter);

}
