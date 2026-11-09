package ru.mustikaev.edu;

public class GradeBinaryRule extends GradeRule<Integer> {
    public GradeBinaryRule() {
        super();
    }

    @Override
    public boolean validate(Integer grade) {
        return grade == 0 || grade == 1;
    }
}
