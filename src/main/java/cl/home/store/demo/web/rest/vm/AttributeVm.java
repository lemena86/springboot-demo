package cl.home.store.demo.web.rest.vm;

import cl.home.store.demo.domain.Attribute;

public class AttributeVm {

    private String name;

    private String value;

    public AttributeVm() {
    }

    public AttributeVm(Attribute attribute) {
        this.name = attribute.getName();
        this.value = attribute.getValue();
    }

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
