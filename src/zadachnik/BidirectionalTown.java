package zadachnik;

import java.util.List;

public class BidirectionalTown extends Town {
    public BidirectionalTown(String title) {
        super(title);
    }

    public BidirectionalTown(String title, List<Route> routes) {
        super(title, routes);
    }

    public BidirectionalTown(String title, Route... routes) {
        super(title, routes);
    }

    @Override
    public void addRoute(Town target, int cost) {
        if (target == null) {
            throw new NullPointerException("В пути не указан город назначения");
        }

        super.addRoute(target, cost);

        for (Route route : target.getRoutes()) {
            if (route.getTarget() == this) {
                route.setCost(cost);
                return;
            }
        }

        target.addRoute(this, cost);
    }
}