import Model.Cellule;
import Model.Environment;
import Model.Virus;
import View.VirusSimulation;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Environment environment = new Environment();

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            environment.addAgent(new Cellule(environment));
        }

        environment.addAgent(new Virus(environment));

        VirusSimulation simulation = new VirusSimulation(environment);
        simulation.run(10);
    }
}

