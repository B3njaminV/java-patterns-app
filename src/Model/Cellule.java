package Model;

import java.util.List;
import java.util.stream.Collectors;

public class Cellule extends Agent {
    public enum State {
        HEALTHY,
        INFECTED
    }

    private State state;
    private Strategy strategy;

    public Cellule(Environment environment, State state) {
        super(environment);
        this.state = state;
        setStrategy(state);
    }

    @Override
    public void perceive() {
        strategy.execute(this);
    }

    @Override
    public void action() {
        // Déplacer la cellule
        if (state == State.HEALTHY) {
            moveToSafePosition();
        } else if (state == State.INFECTED) {
            spreadInfection();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        setStrategy(state);
    }

    private void setStrategy(State state) {
        if (state == State.HEALTHY) {
            this.strategy = new HealthyStrategy();
        } else if (state == State.INFECTED) {
            this.strategy = new InfectedStrategy();
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

    private void moveToSafePosition() {
        List<Agent> neighbors = getNeighbors();
        boolean isNearVirus = neighbors.stream().anyMatch(agent -> agent instanceof Virus);
        if (isNearVirus) {
            x = random.nextInt(environment.getWidth());
            y = random.nextInt(environment.getHeight());
        }
    }

    private void spreadInfection() {
        List<Agent> neighbors = getNeighbors();
        for (Agent neighbor : neighbors) {
            if (neighbor instanceof Cellule) {
                Cellule cellule = (Cellule) neighbor;
                if (cellule.getState() == State.HEALTHY) {
                    cellule.setState(State.INFECTED);
                }
            }
        }
    }
}
