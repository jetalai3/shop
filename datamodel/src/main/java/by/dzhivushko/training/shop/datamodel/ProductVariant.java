package by.dzhivushko.training.shop.datamodel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ProductVariant extends AbstractModel {

    @Column
    private Double priceInfluence;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    private Product product;

    @Column
    private String name;

    @JoinTable(name = "product_variant_2_attribute", joinColumns = { @JoinColumn(name = "product_variant_id") }, inverseJoinColumns = { @JoinColumn(name = "attribute_id") })
    @ManyToMany(targetEntity = Attribute.class, fetch = FetchType.LAZY)
    private List<Attribute> attribute;

    public Double getPriceInfluence() {
        return priceInfluence;
    }

    public void setPriceInfluence(Double priceInfluence) {
        this.priceInfluence = priceInfluence;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Attribute> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<Attribute> attribute) {
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
