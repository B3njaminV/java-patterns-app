package Model;

import java.util.List;

public class HealthyStrategy implements Strategy {
    @Override
    public void execute(Cell cell) {
        // Les cellules saines cherchent à éviter les virus
        List<Agent> neighbors = cell.getNeighbors();
        boolean isNearVirus = neighbors.stream().anyMatch(agent -> agent instanceof Virus);
        if (isNearVirus) {
            // Move to a random position if near a virus
            cell.x = cell.random.nextInt(cell.environment.getWidth());
            cell.y = cell.random.nextInt(cell.environment.getHeight());
        }
    }
}
