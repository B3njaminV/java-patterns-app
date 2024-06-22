package Model;

public class AgentFactory {
    public static Agent createAgent(String type, Environment environment, Cellule.State state) {
        switch (type) {
            case "Cellule":
                return new Cellule(environment, state);
            case "Virus":
                return new Virus(environment);
            default:
                throw new IllegalArgumentException("Type d'agent inconnu");
        }
    }
}