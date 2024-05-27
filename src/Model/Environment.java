package Model;

import java.util.List;
import java.util.ArrayList;

public class Environment {
    private List<Agent> agents;
    private List<Observer> observers;

    public Environment() {
        this.agents = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
        notifyObservers();
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void update() {
        for (Agent agent : agents) {
            agent.action();
        }
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}


