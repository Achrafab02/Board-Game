package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SoftSkillFactoryTest {

    @Test
    public void test_create_soft_skill() {
        SoftSkillFactory factory = new MockSoftSkillFactory();

        SoftSkill softSkill = factory.createSoftSkill();

        assertTrue(softSkill instanceof Brilliant);
    }

    private static class MockSoftSkillFactory extends SoftSkillFactory {
        @Override
        protected SoftSkill getSoftSkill() {
            return new Brilliant();
        }
    }
}
