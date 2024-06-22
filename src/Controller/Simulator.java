package Controller;

import Model.*;
import View.SimulatorView;

import javax.swing.*;

public class Simulator {
    private static Simulator instance;
    private Environment environment;
    private SimulatorView simulatorView;

    private Simulator() {
        environment = new Environment(20, 20);
        simulatorView = new SimulatorView(environment);
    }

    public static Simulator getInstance() {
        if (instance == null) {
            instance = new Simulator();
        }
        return instance;
    }

    public void setup() {
        // Cellules saines
        for (int i = 0; i < 90; i++) {
            environment.addAgent(AgentFactory.createAgent("Cellule", environment, Cellule.State.HEALTHY));
        }
        // Cellules infectées
        for (int i = 0; i < 5; i++) {
            environment.addAgent(AgentFactory.createAgent("Cellule", environment, Cellule.State.INFECTED));
        }
        // Virus
        for (int i = 0; i < 5; i++) {
            environment.addAgent(AgentFactory.createAgent("Virus", environment, null));
        }
    }

    public void run() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simulateur Système Multi-Agents");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(simulatorView);
            frame.pack();
            frame.setVisible(true);

            new Timer(1000, e -> {
                environment.update();
                simulatorView.repaint();
            }).start();
        });
    }
}