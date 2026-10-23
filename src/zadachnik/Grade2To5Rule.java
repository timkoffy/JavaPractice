package zadachnik;

public class Grade2To5Rule extends GradeRule {
    public Grade2To5Rule() {
        super();
    }

    @Override
    public boolean validate(Integer grade) {
        return grade >= 2 && grade <= 5;
    }
}
