package ru.mustikaev.edu;

public class GradeEvenRule extends GradeRule<Integer> {
    public GradeEvenRule() {
        super();
    }

    @Override
    public boolean validate(Integer grade) {
        return grade % 2 == 0;
    }
}
