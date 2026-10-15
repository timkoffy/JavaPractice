package zadachnik;

public class GradeEvenRule extends GradeRule {
    @Override
    public boolean validate(Integer grade) {
        return grade % 2 == 0;
    }
}
