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
            agent.action();
        }
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

