package zadachnik;

public class GradeBinaryRule extends GradeRule {
    @Override
    public boolean validate(Integer grade) {
        return grade == 0 || grade == 1;
    }
}
