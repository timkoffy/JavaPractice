package zadachnik;

public class SizeProperty extends Property {
    public SizeProperty(Integer value) {
        super("size", value);
    }

    @Override
    public Integer getValue() {
        return (Integer) super.getValue();
    }
}
