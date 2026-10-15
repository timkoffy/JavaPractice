package zadachnik;

public class Grade2To5Rule extends GradeRule {
    @Override
    public boolean validate(Integer grade) {
        return grade >= 2 && grade <= 5;
    }
}
