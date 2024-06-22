package Model;

public class AgentFactory {
    public static Agent createAgent(String type, Environment environment, Cell.State state) {
        switch (type) {
            case "Cell":
                return new Cell(environment, state);
            case "Virus":
                return new Virus(environment);
            default:
                throw new IllegalArgumentException("Type d'agent inconnu");
        }
    }
}