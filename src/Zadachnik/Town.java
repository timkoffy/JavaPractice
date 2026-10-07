package Zadachnik;

import java.util.ArrayList;
import java.util.List;

public class Town {
    private String title;
    private List<Route> routes;

    public Town(String title) {
        this(title, new ArrayList<>());
    }

    public Town(String title, List<Route> routes) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Город должен быть с названием");
        }
        this.title = title;
        this.routes = new ArrayList<>(routes);
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
            throw new IllegalArgumentException("В пути не указан город назначения");
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
            throw new IllegalArgumentException("В пути не указан город назначения");
        }

        for (Route route : routes) {
            if (route.getTarget() == target) {
                routes.remove(route);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Город " + title + ": " + routes;
    }
}
