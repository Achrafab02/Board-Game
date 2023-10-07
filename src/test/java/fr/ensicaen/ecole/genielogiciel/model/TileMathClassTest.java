package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TileMathClassTest {
    @Test
    public void test_get_move_instruction_course() {
        TileMathClass tile = new TileMathClass();

        ArrayList<HardSkill> hardSkillsList = new ArrayList<>();
        hardSkillsList.add(new Mathematics(2));

        Player p = new Player("bob", hardSkillsList, "noTraining");

        assertEquals(0, tile.getMoveInstruction(p)._moveCount);
        assertEquals(3, p.getHardSkillLevel(Mathematics.class));
    }
}
