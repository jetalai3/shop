package by.dzhivushko.training.shop.dataaccess.impl;

import org.springframework.stereotype.Repository;

import by.dzhivushko.training.shop.dataaccess.ProductDao;
import by.dzhivushko.training.shop.datamodel.Product;

@Repository
public class ProductDaoImpl extends AbstractDaoImpl<Product, Long> implements ProductDao {

    protected ProductDaoImpl() {
        super(Product.class);
    }

}
