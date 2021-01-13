package by.tc.task03.entity;

import java.util.Objects;

public class Attribute {
    private String nameAttribute;
    private String valueAttribute;

    public Attribute() {

    }

    public Attribute(String nameAttribute, String valueAttribute) {
        this.nameAttribute = nameAttribute;
        this.valueAttribute = valueAttribute;
    }

    public String getNameAttribute() {
        return nameAttribute;
    }

    public void setNameAttribute(String nameAttribute) {
        this.nameAttribute = nameAttribute;
    }

    public String getValueAttribute() {
        return valueAttribute;
    }

    public void setValueAttribute(String valueAttribute) {
        this.valueAttribute = valueAttribute;
    }

    @Override
    public String toString() {
        return nameAttribute + " " + valueAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attribute)) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(nameAttribute, attribute.nameAttribute) &&
                Objects.equals(valueAttribute, attribute.valueAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameAttribute, valueAttribute);
    }
}
