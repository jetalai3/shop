package by.dzhivushko.training.shop.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Attribute extends AbstractModel {
    @Column
    private String name;
    @Column
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
