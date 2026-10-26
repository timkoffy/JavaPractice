package ru.mustikaev.towns;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Town {
    private String title;
    protected List<Route> routes;

    public Town(String title) {
        this(title, new ArrayList<>());
    }

    public Town(String title, List<Route> routes) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Город должен быть с названием");
        }
        this.title = title;

        this.routes = new ArrayList<>();
        if (routes != null) {
            for (Route route : routes) {
                if (route == null || route.getTarget() == null) {
                    throw new NullPointerException("Путь и город должны быть заданы");
                }
                this.addRoute(route.getTarget(), route.getCost());
            }
        }
    }

    public Town(String title, Route... routes) {
        this(title, List.of(routes));
    }

    public String getTitle() {
        return title;
    }

    public List<Route> getRoutes() {
        return new ArrayList<>(routes);
    }

    public void addRoute(Town target, int cost) {
        if (target == null) {
            throw new NullPointerException("В пути не указан город назначения");
        }

        for (Route route : routes) {
            if (route.getTarget() == target) {
                route.setCost(cost);
                return;
            }
        }

        this.routes.add(new Route(target, cost));
    }

    public void removeRoute(Town target) {
        if (target == null) {
            throw new NullPointerException("В пути не указан город назначения");
        }

        for (Route route : routes) {
            if (route.getTarget() == target) {
                routes.remove(route);
                return;
            }
        }
    }

    @Override 
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Town)) return false;
        
        Town town = (Town) o;

        if (!title.equals(town.title)) return false;

        if (this.routes.size() != town.routes.size()) return false;

        for (Route routeA : this.routes) {
            boolean found = false;
            for (Route routeB : town.routes) {
                if (routeA.equals(routeB)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Route route : routes) {
            hash += route.hashCode();
        }
        return Objects.hash(title, hash);
    }

    @Override
    public String toString() {
        return "Город " + title + ": " + routes;
    }
}
