package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import static org.junit.jupiter.api.Assertions.*;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.action.ModifySkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TileComputerScienceClassTest {

    @Test
    public void test_fetch_instruction() {
        int positionIndex = 5;
        Point coordinates = new Point(2, 3);
        TileComputerScienceClass tile = new TileComputerScienceClass(positionIndex, coordinates);
        Player player = new Player();

        Action instruction = tile.fetchInstruction(player);

        assertTrue(instruction instanceof ModifySkillLevel);
        ModifySkillLevel modifySkillLevel = (ModifySkillLevel) instruction;
        assertEquals(ComputerScience.class, modifySkillLevel.getHardSkillClass());
        assertEquals(1, modifySkillLevel.getLevelIncrease());
    }
}
