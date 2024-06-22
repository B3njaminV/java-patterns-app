package Model;

import java.util.List;
import java.util.ArrayList;

public class Environment {
    private List<Agent> agents;
    private int width;
    private int height;

    public Environment(int width, int height) {
        this.width = width;
        this.height = height;
        this.agents = new ArrayList<>();
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    public void update() {
        for (Agent agent : agents) {
            agent.perceive();
        }
        for (Agent agent : agents) {
            agent.act();
        }
    }

    public void display() {
        char[][] grid = new char[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = '.';
            }
        }

        for (Agent agent : agents) {
            int x = agent.getX();
            int y = agent.getY();
            if (agent instanceof Cell) {
                Cell cell = (Cell) agent;
                if (cell.getState() == Cell.State.HEALTHY) {
                    grid[x][y] = 'H';
                } else if (cell.getState() == Cell.State.INFECTED) {
                    grid[x][y] = 'I';
                }
            } else if (agent instanceof Virus) {
                grid[x][y] = 'V';
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Agent> getAgents() {
        return agents;
    }
}

