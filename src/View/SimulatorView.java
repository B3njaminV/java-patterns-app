package View;

import Model.*;

import javax.swing.*;
import java.awt.*;

public class SimulatorView extends JPanel {
    private static final int CELL_SIZE = 20;
    private Environment environment;
    private Image healthyImage;
    private Image infectedImage;
    private Image virusImage;

    public SimulatorView(Environment environment) {
        this.environment = environment;
        this.setPreferredSize(new Dimension(environment.getWidth() * CELL_SIZE, environment.getHeight() * CELL_SIZE));
        this.healthyImage = new ImageIcon(getClass().getResource("/healthy.png")).getImage();
        this.infectedImage = new ImageIcon(getClass().getResource("/infected.png")).getImage();
        this.virusImage = new ImageIcon(getClass().getResource("/virus.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Agent agent : environment.getAgents()) {
            int x = agent.getX() * CELL_SIZE;
            int y = agent.getY() * CELL_SIZE;
            if (agent instanceof Cellule) {
                Cellule cellule = (Cellule) agent;
                if (cellule.getState() == Cellule.State.HEALTHY) {
                    g.drawImage(healthyImage, x, y, CELL_SIZE, CELL_SIZE, this);
                } else if (cellule.getState() == Cellule.State.INFECTED) {
                    g.drawImage(infectedImage, x, y, CELL_SIZE, CELL_SIZE, this);
                }
            } else if (agent instanceof Virus) {
                g.drawImage(virusImage, x, y, CELL_SIZE, CELL_SIZE, this);
            }
        }
    }
}

