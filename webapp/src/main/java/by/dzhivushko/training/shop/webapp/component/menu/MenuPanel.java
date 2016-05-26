package by.dzhivushko.training.shop.webapp.component.menu;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import by.dzhivushko.training.shop.webapp.page.home.HomePage;
import by.dzhivushko.training.shop.webapp.page.product.ProductsPage;

public class MenuPanel extends Panel {

    public MenuPanel(String id) {
        super(id);
        // setRenderBodyOnly(true);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Link("link-home") {
            @Override
            public void onClick() {
                setResponsePage(new HomePage());
            }
        });

        add(new Link("link-products") {
            @Override
            public void onClick() {
                setResponsePage(new ProductsPage());
            }
        });

    }
}
