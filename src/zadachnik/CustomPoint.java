package zadachnik;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomPoint {
    private List<Integer> coords;
    private Map<String, Object> properties;

    public CustomPoint(List<Integer> coords) {
        if (coords.isEmpty()) {
            throw new IllegalArgumentException("У точки должно быть хотя бы одно измерение");
        }
        this.coords = coords;
        this.properties = new LinkedHashMap<>();
    }

    public CustomPoint(Integer... coords) {
        this(List.of(coords));
    }

    public CustomPoint set(String name, Object value) {
        properties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        String res = "Точка в координате {";

        for (int i = 0; i < coords.size() - 1; i++) {
            res += coords.get(i) + ",";
        }
        res += coords.getLast() + "}";

        if (!properties.isEmpty()) {
            for (Map.Entry<String, Object> e : properties.entrySet()) {
                res += ", " + e.getKey() + ": " + e.getValue();
            }
        }

        return res;
    }
}
