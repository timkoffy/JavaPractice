package Zadachnik;

public class Gun extends Weapon {
    static private final int DEFAULT_MAX_BULLET_COUNT = 5;
    private int maxBulletCount;

    public Gun(int maxBulletCount, int bulletCount) {
        super(0);

        if (maxBulletCount < 0) {
            maxBulletCount = DEFAULT_MAX_BULLET_COUNT;
        }
        this.maxBulletCount = maxBulletCount;

        if (bulletCount < 0) {
            bulletCount = 0;
        } else if (bulletCount > maxBulletCount) {
            bulletCount = maxBulletCount;
        }
        load(bulletCount);
    }

    public Gun(int maxBulletCount) {
        this(maxBulletCount, maxBulletCount);
    }

    public Gun() {
        this(DEFAULT_MAX_BULLET_COUNT);
    }

    public int getMaxBulletCount() {
        return maxBulletCount;
    }

    public int getBulletCount() {
        return ammo();
    }

    public boolean isLoaded() {
        return ammo() > 0;
    }

    public void shoot() {
        if (ammo() < 1) {
            System.out.println("клац");
        } else {
            System.out.println("пау");
            getAmmo();
        }
    }

    public int reload(int bulletCount) {
        if (bulletCount < 0) {
            throw new IllegalArgumentException("Передано отрицательное количество патронов для перезарядки");
        }

        int current = ammo();
        int freeSpace = maxBulletCount - current;

        if (bulletCount <= freeSpace) {
            load(current + bulletCount);
            return 0;
        }

        int overflow = bulletCount - freeSpace;
        load(maxBulletCount);
        return overflow;
    }

    public int unload() {
        int res = ammo();
        load(0);
        return res;
    }
}
