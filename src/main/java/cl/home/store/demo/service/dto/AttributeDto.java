package cl.home.store.demo.service.dto;

import cl.home.store.demo.domain.Attribute;

import java.util.Objects;

public class AttributeDto {

    private String name;

    private String value;

    public AttributeDto() {
    }

    public AttributeDto(Attribute attribute) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeDto that = (AttributeDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "AttributeDto{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
