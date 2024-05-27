package Model;

public class Cellule extends Agent {
    private boolean infected;

    public Cellule(Environment environment) {
        super(environment);
        this.infected = false;
    }

    public boolean isInfected() {
        return infected;
    }

    public void infect() {
        infected = true;
    }

    @Override
    public void action() {
        //
    }
}
