package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TileMathExamTest {
    @Test
    public void test_get_move_instruction_exam_ok() {
        TileMathExam tile = new TileMathExam();

        ArrayList<HardSkill> hardSkillsList = new ArrayList<>();
        hardSkillsList.add(new Mathematics(4));

        Player p = new Player("bob", hardSkillsList, "noTraining");

        assertEquals(0, tile.getMoveInstruction(p)._moveCount);
        assertEquals(4, p.getHardSkillLevel(Mathematics.class));
    }

    @Test
    public void test_get_move_instruction_exam_non_ok() {
        TileMathExam tile = new TileMathExam();

        ArrayList<HardSkill> hardSkillsList = new ArrayList<>();
        hardSkillsList.add(new Mathematics(2));

        Player p = new Player("bob", hardSkillsList, "noTraining");

        assertEquals(-2, tile.getMoveInstruction(p)._moveCount);
        assertEquals(2, p.getHardSkillLevel(Mathematics.class));
    }
}
