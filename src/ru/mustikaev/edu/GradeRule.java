package ru.mustikaev.edu;

public abstract class GradeRule<T> {
    public static final GradeRule INSTANCE = new GradeAllTrueRule();

    public GradeRule() {}

    private static class GradeAllTrueRule<T> extends GradeRule<T> {
        private GradeAllTrueRule() { super(); }

        @Override
        public boolean validate(T grade) {
            return true;
        }
    }

    public abstract boolean validate(T grade);
}