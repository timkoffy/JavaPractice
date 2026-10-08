package zadachnik;

import java.util.ArrayList;
import java.util.List;

public class CustomPoint {
    private List<Integer> coords;
    private List<Object> properties;

    public CustomPoint(List<Integer> coords, List<Object> properties) {
        if (coords.isEmpty()) {
            throw new IllegalArgumentException("У точки должно быть хотя бы одно измерение");
        }
        this.coords = coords;
        this.properties = properties;
    }

    public CustomPoint(List<Integer> coords) {
        this(coords, new ArrayList<>());
    }

    @Override
    public String toString() {
        String res = "Точка в координате {";

        for (int i = 0; i < coords.size() - 1; i++) {
            res += coords.get(i) + ",";
        }
        res += coords.getLast() + "}";

        if (!properties.isEmpty()) {
            for (int i = 0; i < properties.size() - 1; i++) {
                res += ", " + properties.get(i);
            }
            res += ", " + properties.getLast() + ".";
        }

        return res;
    }
}
