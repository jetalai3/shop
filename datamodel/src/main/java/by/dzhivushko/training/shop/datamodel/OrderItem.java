package by.dzhivushko.training.shop.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem extends AbstractModel {

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(targetEntity = ProductVariant.class, fetch = FetchType.LAZY)
    private ProductVariant productVariant;

    @Column
    private Integer quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ProductVariant getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(ProductVariant productVariant) {
        this.productVariant = productVariant;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
