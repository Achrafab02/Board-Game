package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SoftSkillRandomFactoryTest {
    @Test
    public void test_create_soft_skill() {
        SoftSkillFactory factory = new SoftSkillRandomFactory();

        SoftSkill softSkill = factory.createSoftSkill();

        assertTrue(softSkill instanceof Dabbler || softSkill instanceof Rigorous || softSkill instanceof Brilliant);
    }
}