package zadachnik;

import java.util.ArrayList;
import java.util.List;

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
    public String toString() {
        return "Город " + title + ": " + routes;
    }
}
