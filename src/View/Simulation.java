package View;

import Model.Environment;

public abstract class Simulation {
    protected Environment environment;

    public Simulation(Environment environment) {
        this.environment = environment;
    }

    public void run(int steps) {
        for (int i = 0; i < steps; i++) {
            environment.update();
            display();
        }
    }

    public abstract void display();
}

