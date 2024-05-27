package Model;

public class Virus extends Agent {
    public Virus(Environment environment) {
        super(environment);
    }

    @Override
    public void action() {
        for (Agent agent : environment.getAgents()) {
            if (agent instanceof Cellule) {
                Cellule cell = (Cellule) agent;
                if (!cell.isInfected()) {
                    if (Math.random() < 0.5) {
                        cell.infect();
                    }
                }
            }
        }
    }
}
