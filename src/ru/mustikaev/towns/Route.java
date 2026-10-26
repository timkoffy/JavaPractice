package ru.mustikaev.towns;

public class Route {
    private Town target;
    private int cost;

    public Route(Town target, int cost) {
        this.target = target;
        this.cost = cost;
    }

    public Route(Town target) {
        this(target, 0);
    }

    public Town getTarget() {
        return target;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Route)) return false;

        Route route = (Route) o;
        return target == route.target;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(target);
    }

    @Override
    public String toString() {
        return target.getTitle() + ": " + cost;
    }
}
