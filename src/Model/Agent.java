package Model;

import java.util.Random;

public abstract class Agent {
    protected Environment environment;
    protected int x;
    protected int y;
    protected Random random;

    public Agent(Environment environment) {
        this.environment = environment;
        this.random = new Random();
        this.x = random.nextInt(environment.getWidth());
        this.y = random.nextInt(environment.getHeight());
    }

    public abstract void perceive();
    public abstract void action();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

