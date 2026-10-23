package ru.mustikaev.animals.cats;

public class MeowManager {
    public static void meowAll(Meowable... objs) {
        for (Meowable obj : objs) {
            obj.meow();
        }
    }
}
