package fr.ensicaen.ecole.genielogiciel.model.player.schooling;

public class SchoolingBuilder {
    public static Schooling createSchooling(String schooling) {
        return switch (schooling) {
            case "noTraining" -> new NoTraining();
            case "ast" -> new AST();
            case "prepa" -> new Prepa();
            default -> throw new IllegalArgumentException("Schooling not found");
        };
    }

    private SchoolingBuilder() {}
}
