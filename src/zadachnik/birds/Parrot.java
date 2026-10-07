package zadachnik.birds;

import java.util.Random;

public class Parrot extends Bird {
    static private final Random RANDOM = new Random();
    private String text;

    public Parrot(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.text = text;
    }

    @Override
    public void sing() {
        int n = 1 + RANDOM.nextInt(text.length());
        System.out.println(text.substring(0, n));
    }
}
