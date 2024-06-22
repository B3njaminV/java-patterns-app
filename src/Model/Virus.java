package Model;

import java.util.List;
import java.util.stream.Collectors;

public class Virus extends Agent {

    public Virus(Environment environment) {
        super(environment);
    }

    @Override
    public void perceive() {
    }

    @Override
    public void action() {
        // Le virus se déplace de manière aléatoire
        x = random.nextInt(environment.getWidth());
        y = random.nextInt(environment.getHeight());

        // Infecter les cellules saines à proximité
        List<Agent> neighbors = getNeighbors();
        for (Agent neighbor : neighbors) {
            if (neighbor instanceof Cellule) {
                Cellule cellule = (Cellule) neighbor;
                if (cellule.getState() == Cellule.State.HEALTHY) {
                    cellule.setState(Cellule.State.INFECTED);
                }
            }
        }
    }

    private boolean isNeighbor(Agent agent) {
        int dx = Math.abs(agent.getX() - this.x);
        int dy = Math.abs(agent.getY() - this.y);
        return dx <= 1 && dy <= 1;
    }

    public List<Agent> getNeighbors() {
        return environment.getAgents().stream()
                .filter(agent -> isNeighbor(agent))
                .collect(Collectors.toList());
    }
}