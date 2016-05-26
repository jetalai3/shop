package by.dzhivushko.training.shop.webapp.page.product;

import javax.inject.Inject;

import by.dzhivushko.training.shop.service.ProductService;
import by.dzhivushko.training.shop.webapp.page.AbstractPage;

public class ProductsPage extends AbstractPage {

    @Inject
    private ProductService productService;

    public ProductsPage() {
        super();

        System.out.print(productService);
    }

}
