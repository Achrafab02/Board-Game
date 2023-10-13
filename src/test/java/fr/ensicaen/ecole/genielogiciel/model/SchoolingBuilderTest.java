package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.schooling.NoTraining;
import fr.ensicaen.ecole.genielogiciel.model.player.schooling.SchoolingBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolingBuilderTest {
    @Test
    public void test_create_schooling() {
        assertTrue(SchoolingBuilder.createSchooling("noTraining") instanceof NoTraining);
    }
}