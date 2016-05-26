package by.dzhivushko.training.shop.webapp.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import by.dzhivushko.training.shop.webapp.component.menu.MenuPanel;
import by.dzhivushko.training.shop.webapp.component.menu.MenuPanelLoggedUser;
import by.dzhivushko.training.shop.webapp.page.product.ProductsPage;

public abstract class AbstractPage extends WebPage {

    public AbstractPage() {
        super();
    }

    public AbstractPage(PageParameters parameters) {
        super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        if (getPage().getClass().equals(ProductsPage.class)) {
            add(new MenuPanelLoggedUser("menu-panel"));
        } else {
            add(new MenuPanel("menu-panel"));
        }

    }

}
