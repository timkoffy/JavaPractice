package ru.mustikaev.edu;

public class GradeEvenRule extends GradeRule {
    public GradeEvenRule() {
        super();
    }

    @Override
    public boolean validate(Integer grade) {
        return grade % 2 == 0;
    }
}
