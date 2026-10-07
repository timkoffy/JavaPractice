package zadachnik;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        meow(1);
    }

    public void meow(int n) {
        String res = name + ": ";

        if (n < 1) return;

        for (int i = 0; i < n - 1; i++) {
            res += "мяу-";
        }

        res += "мяу!";

        System.out.println(res);
    }
}
