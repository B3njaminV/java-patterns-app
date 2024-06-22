package Model;

import java.util.List;

public class InfectedStrategy implements Strategy {
    @Override
    public void execute(Cell cell) {
        List<Agent> neighbors = cell.getNeighbors();
        for (Agent neighbor : neighbors) {
            if (neighbor instanceof Cell) {
                Cell neighborCell = (Cell) neighbor;
                if (neighborCell.getState() == Cell.State.HEALTHY) {
                    neighborCell.setState(Cell.State.INFECTED);
                }
            }
        }
    }
}
