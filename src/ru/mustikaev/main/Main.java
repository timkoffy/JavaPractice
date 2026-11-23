package ru.mustikaev.main;

import java.util.Comparator;
import java.util.List;

import ru.mustikaev.Flow;


public class Main {
    public static void main(String[] args) {
        Flow<Integer> flow = new Flow<>(List.of(1, 2, 3, 4, 5, 6));
        System.out.print("перед фильтром:");
        for (Integer num : flow) {
            System.out.print(num + " ");
        }
        System.out.println();

        flow = flow.filter(x -> true);

        System.out.print("после фильтра:");
        for (Integer num : flow) {
            System.out.print(num + " ");
        }
        System.out.println();
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