package Model;

import java.util.List;

public class HealthyStrategy implements Strategy {
    @Override
    public void execute(Cellule cellule) {
        // Les cellules saines cherchent à éviter les virus
        List<Agent> neighbors = cellule.getNeighbors();
        boolean isNearVirus = neighbors.stream().anyMatch(agent -> agent instanceof Virus);
        if (isNearVirus) {
            cellule.x = cellule.random.nextInt(cellule.environment.getWidth());
            cellule.y = cellule.random.nextInt(cellule.environment.getHeight());
        }
    }
}
