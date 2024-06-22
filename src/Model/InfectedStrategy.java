package Model;

import java.util.List;

public class InfectedStrategy implements Strategy {
    @Override
    public void execute(Cellule cellule) {
        // Les cellules infectées cherchent à propager l'infection
        List<Agent> neighbors = cellule.getNeighbors();
        for (Agent neighbor : neighbors) {
            if (neighbor instanceof Cellule) {
                Cellule neighborCell = (Cellule) neighbor;
                if (neighborCell.getState() == Cellule.State.HEALTHY) {
                    neighborCell.setState(Cellule.State.INFECTED);
                }
            }
        }
    }
}
