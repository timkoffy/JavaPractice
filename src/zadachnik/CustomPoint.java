package zadachnik;

import java.util.ArrayList;
import java.util.List;

public class CustomPoint {
    private List<Integer> coords;
    private List<Property> properties;

    public CustomPoint(List<Integer> coords, Property... properties) {
        if (coords.isEmpty()) {
            throw new IllegalArgumentException("У точки должно быть хотя бы одно измерение");
        }
        this.coords = coords;

        this.properties = new ArrayList<>();
        if (properties == null) return;
        for (Property p : properties) {
            putProperty(p);
        }
    }

    public CustomPoint(Integer... coords) {
        this(List.of(coords));
    }

    public CustomPoint(CustomPoint point) {
        this.coords = new ArrayList<>(point.coords);
        this.properties = new ArrayList<>(point.properties);
    }

    public void putProperty(Property property) {
        Class propertyType = property.getClass();

        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getClass() == propertyType) {
                properties.set(i, property);
                return;
            }
        }

        properties.add(property);
    }

    public <T extends Property> T getProperty(Class<T> type) {
        for (Property property : properties) {
            if (property.getClass() == type) {
                return (T) property;
            }
        }
        return null;
    }

    public List<Property> getProperties() {
        return new ArrayList<>(properties);
    }

    @Override
    public String toString() {
        String res = "Точка в координате {";

        for (int i = 0; i < coords.size() - 1; i++) {
            res += coords.get(i) + ",";
        }
        res += coords.getLast() + "}";

        if (!properties.isEmpty()) {
            for (Property property : properties) {
                res += ", " + property.getKey() + ": " + property.getValue();
            }
        }

        return res;
    }
}
