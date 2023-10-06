package fr.ensicaen.ecole.genielogiciel.model_merge_problems;

public class SchoolingBuilder {
    public static Schooling createSchooling(String schooling) {
        return switch (schooling) {
            case "noTraining" -> new NoTraining();
            case "ast" -> new AST();
            case "prepa" -> new Prepa();
            // TODO: add other schoolings
            default -> throw new IllegalArgumentException("Schooling not found");
        };
    }

    private SchoolingBuilder() {}
}
