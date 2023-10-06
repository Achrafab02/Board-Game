package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolingBuilderTest {
    @Test
    public void test_create_schoolin() {
        assertTrue(SchoolingBuilder.createSchooling("noTraining") instanceof NoTraining );
    }
}