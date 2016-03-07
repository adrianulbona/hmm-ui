package io.github.adrianulbona.hmm.ui;

/**
 * Created by adrianulbona on 06.03.2016.
 */
public class App implements RouteProvider {

    public static void main(String[] args) {
        new App().registerRoutes();
    }

    @Override
    public void registerRoutes() {
        new Validator().registerRoutes();
    }
}
