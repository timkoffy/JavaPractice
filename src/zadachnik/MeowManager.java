package zadachnik;

public class MeowManager {
    public static void meowAll(Meowable... objs) {
        for (Meowable obj : objs) {
            obj.meow();
        }
    }
}
