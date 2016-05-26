package by.dzhivushko.training.shop.webapp.page.product;

import javax.inject.Inject;

import by.dzhivushko.training.shop.service.ProductService;
import by.dzhivushko.training.shop.webapp.page.AbstractPage;
import by.dzhivushko.training.shop.webapp.page.product.panel.ProductListPanel;

public class ProductsPage extends AbstractPage {

    @Inject
    private ProductService productService;

    public ProductsPage() {
        super();
        add(new ProductListPanel("list-panel"));
    }

}
