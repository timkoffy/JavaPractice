package zadachnik.birds;

public class BirdManager {
    public static void singAll(Bird... birds) {
        for (Bird bird : birds) {
            bird.sing();
        }
    }
}