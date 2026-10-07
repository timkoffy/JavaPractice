package zadachnik;

public class House {
    private int floorCount;

    public House(int floorCount) {
        if (floorCount < 1) {
            throw new IllegalArgumentException("Количество этажей дома должно быть больше 0");
        }
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        String res = "Дом с " + floorCount;

        if (floorCount % 10 == 1) {
            res += " этажом";
        } else {
            res += " этажами";
        }

        return res;
    }
}
