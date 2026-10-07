package Zadachnik;

public class Gun {
    static private final int DEFAULT_MAX_BULLET_COUNT = 5;
    private int bulletCount;
    private int maxBulletCount;

    public Gun(int maxBulletCount, int bulletCount) {
        if (maxBulletCount < 0) {
            maxBulletCount = DEFAULT_MAX_BULLET_COUNT;
        }
        this.maxBulletCount = maxBulletCount;

        if (bulletCount < 0) {
            bulletCount = 0;
        } else if (bulletCount > maxBulletCount) {
            bulletCount = maxBulletCount;
        }
        this.bulletCount = bulletCount;
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
        return bulletCount;
    }

    public boolean isLoaded() {
        return bulletCount > 0;
    }

    public void fire() {
        if (bulletCount < 1) {
            System.out.println("клац");
        } else {
            System.out.println("пау");
            bulletCount--;
        }
    }

    public int reload(int bulletCount) {
        if (bulletCount < 0) {
            throw new IllegalArgumentException("Передано отрицательное количество патронов для перезарядки");
        }

        int freeSpace = maxBulletCount - this.bulletCount;

        if (bulletCount <= freeSpace) {
            this.bulletCount += bulletCount;
            return 0;
        }

        int overflow = bulletCount - freeSpace;
        this.bulletCount = maxBulletCount;
        return overflow;
    }

    public int unload() {
        int res = bulletCount;
        bulletCount = 0;
        return res;
    }
}
