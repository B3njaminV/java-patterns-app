package Model;

import java.util.List;
import java.util.stream.Collectors;

public class Cell extends Agent {
    public enum State {
        HEALTHY,
        INFECTED
    }

    private State state;
    private Strategy strategy;

    public Cell(Environment environment, State state) {
        super(environment);
        this.state = state;
        setStrategy(state);
    }

    @Override
    public void perceive() {
        strategy.execute(this);
    }

    @Override
    public void act() {
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
            // Move to a random position if near a virus
            x = random.nextInt(environment.getWidth());
            y = random.nextInt(environment.getHeight());
        }
    }

    private void spreadInfection() {
        // Infect neighbors
        List<Agent> neighbors = getNeighbors();
        for (Agent neighbor : neighbors) {
            if (neighbor instanceof Cell) {
                Cell cell = (Cell) neighbor;
                if (cell.getState() == State.HEALTHY) {
                    cell.setState(State.INFECTED);
                }
            }
        }
    }
}
