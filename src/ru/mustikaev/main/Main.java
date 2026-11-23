package ru.mustikaev.main;

import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        System.out.println(StringComparator.getInstance().compare("aaa", "aaaaaa"));
    }

    public static class StringComparator implements Comparator<String> {
        private static StringComparatorLazyInitializer INSTANCE_LAZY_INIT = new StringComparatorLazyInitializer();;

        private StringComparator() {}

        public static Comparator<String> getInstance() {
            return INSTANCE_LAZY_INIT;
        }

        private static class StringComparatorLazyInitializer implements Comparator<String> {
            private StringComparator sc;

            @Override
            public int compare(String s1, String s2) {
                if (sc == null) sc = new StringComparator();
                return sc.compare(s1, s2);
            }
        }

        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}