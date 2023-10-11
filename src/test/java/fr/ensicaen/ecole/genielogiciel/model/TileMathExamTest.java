package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileMathExam;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TileMathExamTest {
    @Test
    public void test_get_move_instruction_exam_ok() {
        TileMathExam tile = new TileMathExam();

        ArrayList<HardSkill> hardSkillsList = new ArrayList<>();
        hardSkillsList.add(new Mathematics(4));

        Player p = new Player("bob", hardSkillsList);

        assertEquals(0, tile.fetchInstruction(p)._moveCount);
        assertEquals(4, p.getHardSkillLevel(Mathematics.class));
    }

    @Test
    public void test_get_move_instruction_exam_non_ok() {
        TileMathExam tile = new TileMathExam();

        ArrayList<HardSkill> hardSkillsList = new ArrayList<>();
        hardSkillsList.add(new Mathematics(2));

        Player p = new Player("bob", hardSkillsList);

        assertEquals(-2, tile.fetchInstruction(p)._moveCount);
        assertEquals(2, p.getHardSkillLevel(Mathematics.class));
    }
}
