package zadachnik.birds;

import java.util.Random;

public class Cuckoo extends Bird {
    static private final Random RANDOM = new Random();

    @Override
    public void sing() {
        int count = 1 + RANDOM.nextInt(10);
        for (int i = 0; i < count; i++) {
            System.out.println("ку-ку");
        }
    }
}
