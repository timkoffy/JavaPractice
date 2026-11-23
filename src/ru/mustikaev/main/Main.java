package ru.mustikaev.main;

import java.util.Comparator;
import java.util.List;

import ru.mustikaev.Flow;


public class Main {
    public static void main(String[] args) {
        System.out.println(test(List.of("djkd", "fdjr", "66", "3", "gfdk")));
    }




    // список строк: убрать все
    //  пустые
    //  нач не с цифры
    // оставшиеся в числа и сложить числа
    public static int test(List<String> strings) {
        Flow<Integer> flow = new Flow<>(strings)
                .filter((String elem) -> elem != null && !elem.isEmpty())
                .filter((String elem) -> Character.isDigit(elem.charAt(0)))
                .map((String elem) -> Integer.parseInt(elem));

        return flow.reduce(0, (Integer a, Integer b) -> a + b);
    }




    // public static class StringComparator implements Comparator<String> {
    //     private static StringComparatorLazyInitializer INSTANCE_LAZY_INIT = new StringComparatorLazyInitializer();;

    //     private StringComparator() {}

    //     public static Comparator<String> getInstance() {
    //         return INSTANCE_LAZY_INIT;
    //     }

    //     private static class StringComparatorLazyInitializer implements Comparator<String> {
    //         private StringComparator sc;

    //         @Override
    //         public int compare(String s1, String s2) {
    //             if (sc == null) sc = new StringComparator();
    //             return sc.compare(s1, s2);
    //         }
    //     }

    //     @Override
    //     public int compare(String s1, String s2) {
    //         return s1.length() - s2.length();
    //     }
    // }
}