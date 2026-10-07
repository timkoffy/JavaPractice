package zadachnik;

public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name(String lastName, String firstName, String middleName) {
        lastName = fixNullString(lastName);
        firstName = fixNullString(firstName);
        middleName = fixNullString(middleName);

        ensureNotEmpty(lastName, firstName, middleName);

        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = fixNullString(lastName);
        ensureNotEmpty(lastName, this.firstName, this.middleName);
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = fixNullString(firstName);
        ensureNotEmpty(this.lastName, firstName, this.middleName);
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        middleName = fixNullString(middleName);
        ensureNotEmpty(this.lastName, this.firstName, middleName);
        this.middleName = middleName;
    }

    public boolean hasMiddleName() {
        return !middleName.isBlank();
    }

    private static String fixNullString(String s) {
        if (s == null) {
            return "";
        }
        return s.trim();
    }

    private static void ensureNotEmpty(String last, String first, String middle) {
        if (last.isBlank() && first.isBlank() && middle.isBlank()) {
            throw new IllegalArgumentException("Хотя бы одна часть имени должна быть непустой");
        }
    }

    @Override
    public String toString() {
        String res = "";

        if (!lastName.isBlank()) {
            res += lastName;
        }

        if (!firstName.isBlank()) {
            res += " " + firstName;
        }

        if (!middleName.isBlank()) {
            res += " " + middleName;
        }

        return res.trim();
    }
}
