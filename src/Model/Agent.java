package Model;

public abstract class Agent {
    protected Environment environment;

    public Agent(Environment environment) {
        this.environment = environment;
    }

    public abstract void action();
}

