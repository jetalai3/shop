package by.dzhivushko.training.shop.webapp.page.product;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import by.dzhivushko.training.shop.datamodel.Product;
import by.dzhivushko.training.shop.webapp.page.AbstractPage;

public class ProductDetailsPage extends AbstractPage {

    public ProductDetailsPage(PageParameters parameters) {
        super(parameters);
    }

    public ProductDetailsPage(Product product) {
        super();

    }

}
