package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.action.ModifySkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TileMathClassTest {

    @Test
    public void test_fetch_instruction() {
        int positionIndex = 5;
        Point coordinates = new Point(2, 3);
        TileMathClass tile = new TileMathClass(positionIndex, coordinates);
        Player player = new Player();

        Action instruction = tile.fetchInstruction(player);

        assertTrue(instruction instanceof ModifySkillLevel);
        ModifySkillLevel modifySkillLevel = (ModifySkillLevel) instruction;
        assertEquals(Mathematics.class, modifySkillLevel.getHardSkillClass());
        assertEquals(1, modifySkillLevel.getLevelIncrease());
    }
}
