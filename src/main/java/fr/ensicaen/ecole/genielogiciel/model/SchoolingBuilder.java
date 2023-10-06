package fr.ensicaen.ecole.genielogiciel.model;

public class SchoolingBuilder {
    public static Schooling createSchooling(String schooling) {
        return switch (schooling) {
            case "noTraining" -> new NoTraining();
            default -> throw new IllegalArgumentException("Schooling not found");
        };
    }

    private SchoolingBuilder() {
    }
}
