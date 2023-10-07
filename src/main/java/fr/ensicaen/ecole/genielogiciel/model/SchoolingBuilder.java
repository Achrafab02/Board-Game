package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.schooling.AST;
import fr.ensicaen.ecole.genielogiciel.model.schooling.NoTraining;
import fr.ensicaen.ecole.genielogiciel.model.schooling.Prepa;
import fr.ensicaen.ecole.genielogiciel.model.schooling.Schooling;

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
