package ru.mustikaev.propeties;

public abstract class Property {
    private String key;
    private Object value;

    public Property(String title, Object value) {
        this.key = title;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Property{" +
                "title='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
