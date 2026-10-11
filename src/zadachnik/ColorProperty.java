package zadachnik;

public class ColorProperty extends Property {
    public ColorProperty(String value) {
        super("color", value);
    }

    @Override
    public String getValue() {
        return (String) super.getValue();
    }
}
