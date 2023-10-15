package fr.ensicaen.ecole.genielogiciel.model.player.hardskills;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HardSkillTest {

    @Test
    public void test_get_score() {
        int initialScore = 10;
        HardSkill skill = new MockHardSkill(initialScore);

        int score = skill.getScore();
        assertEquals(initialScore, score);
    }

    @Test
    public void test_set_score() {
        int initialScore = 10;
        HardSkill skill = new MockHardSkill(initialScore);

        int newScore = 15;
        skill.setScore(newScore);

        int score = skill.getScore();
        assertEquals(newScore, score);
    }

    @Test
    public void test_add_to_score() {
        int initialScore = 10;
        HardSkill skill = new MockHardSkill(initialScore);

        int scoreToAdd = 5;
        skill.addToScore(scoreToAdd);

        int score = skill.getScore();
        assertEquals(15, score);

        skill.addToScore(-16);

        score = skill.getScore();
        assertEquals(0, score);
    }

    private static class MockHardSkill extends HardSkill {
        MockHardSkill(int score) {
            super(score);
        }
    }
}
