package zadachnik;

public class Shooter {
    private String name;
    private Weapon weapon;

    public Shooter(String name, Weapon weapon) {
        this.name = name;
    }

    public Shooter(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon == null) {
            System.out.println("не могу участвовать в перестрелке");
            return;
        }
        weapon.shoot();
    }
}
