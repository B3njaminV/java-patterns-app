import View.Simulator;

public class Main {
    public static void main(String[] args) {
        Simulator simulator = Simulator.getInstance();
        simulator.setup();
        simulator.run();
    }
}

