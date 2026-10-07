package Zadachnik;

public class Human {
    static private final int UNKNOWN_HEIGHT = -1;

    private Name name;
    private int height;
    private Human father;

    public Human(Name name, int height) {
        if (name == null) {
            throw new NullPointerException("Имя при создании человека не указано");
        }
        this.name = name;
        this.height = height;
    }

    public Human(Name name) {
        this(name, UNKNOWN_HEIGHT);
    }

    public Human(String firstName) {
        this(new Name("", firstName, ""));
    }

    public Human(Name name, Human father) {
        this(name);
        this.father = father;
        setMiddleNameByFather(father);
    }

    public Human(String firstName, Human father) {
        this(new Name("", firstName, ""), father);
    }

    public String getFirstName() {
        return name.getFirstName();
    }

    public String getLastName() {
        if (name.getLastName().isBlank() && father != null) {
            return father.getLastName();
        } else {
            return name.getLastName();
        }
    }

    public String getMiddleName() {
        return name.getMiddleName();
    }

    public Name getName() {
        return name;
    }

    public Human getFather() {
        return father;
    }

    private void setMiddleNameByFather(Human father) {
        if (father != null && !name.hasMiddleName()) {
            name.setMiddleName(father.name.getFirstName() + "ович");
        }
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
