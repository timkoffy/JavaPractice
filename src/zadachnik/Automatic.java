package zadachnik;

public class Automatic extends Gun {
    private final int rateOfFire;

    public Automatic(int maxBulletCount) {
        super(maxBulletCount);

        int capacity = getMaxBulletCount();

        int rateOfFire = capacity / 2;
        if (rateOfFire < 1) rateOfFire = 1;

        this.rateOfFire = rateOfFire;
    }

    public Automatic() {
        this(30);
    }

    public Automatic(int maxBulletCount, int rateOfFire) {
        super(maxBulletCount);
        if (rateOfFire < 1) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной");
        }
        this.rateOfFire = rateOfFire;
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    @Override
    public void shoot() {
        for (int i = 0; i < rateOfFire; i++) {
            super.shoot();
        }
    }

    public void fire(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Количество секунд не может быть отрицательным");
        }
        int totalShots = seconds * rateOfFire;
        for (int i = 0; i < totalShots; i++) {
            super.shoot();
        }
    }
}