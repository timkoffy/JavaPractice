package ru.mustikaev.edu;

public abstract class GradeRule {
    public static final GradeRule INSTANCE = new GradeAllTrueRule();

    public GradeRule() {}

    private static class GradeAllTrueRule extends GradeRule {
        private GradeAllTrueRule() { super(); }

        @Override
        public boolean validate(Integer grade) {
            return true;
        }
    }

    public abstract boolean validate(Integer grade);
}