package View;

import Model.*;

public class Simulator {
    private static Simulator instance;
    private Environment environment;

    private Simulator() {
        environment = new Environment(10, 10);
    }

    public static Simulator getInstance() {
        if (instance == null) {
            instance = new Simulator();
        }
        return instance;
    }

    public void setup() {
        // Cellules saines
        for (int i = 0; i < 90; i++) {
            environment.addAgent(AgentFactory.createAgent("Cell", environment, Cell.State.HEALTHY));
        }
        // Cellules infectées
        for (int i = 0; i < 5; i++) {
            environment.addAgent(AgentFactory.createAgent("Cell", environment, Cell.State.INFECTED));
        }
        // Virus
        for (int i = 0; i < 5; i++) {
            environment.addAgent(AgentFactory.createAgent("Virus", environment, null));
        }
    }

    public void run() {
        while (true) {
            environment.update();
            environment.display();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}