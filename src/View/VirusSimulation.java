package View;

import Model.Agent;
import Model.Cellule;
import Model.Environment;
import Model.Observer;

public class VirusSimulation extends Simulation implements Observer {

    public VirusSimulation(Environment environment) {
        super(environment);
        environment.addObserver(this);
    }

    @Override
    public void display() {
        for (Agent agent : environment.getAgents()) {
            if (agent instanceof Cellule) {
                Cellule cell = (Cellule) agent;
                System.out.print(cell.isInfected() ? "I " : ". ");
            }
        }
        System.out.println();
    }

    @Override
    public void update() {
        display();
    }

}
