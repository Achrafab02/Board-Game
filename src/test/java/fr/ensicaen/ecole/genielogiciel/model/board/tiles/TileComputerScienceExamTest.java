package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.action.MoveIfInsufficientSkillLevel;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TileComputerScienceExamTest {

    @Test
    public void test_fetch_instruction() {
        int positionIndex = 5;
        Point coordinates = new Point(2, 3);
        TileComputerScienceExam tile = new TileComputerScienceExam(positionIndex, coordinates);
        Player player = new Player();

        Action instruction = tile.fetchInstruction(player);

        assertTrue(instruction instanceof MoveIfInsufficientSkillLevel);
        MoveIfInsufficientSkillLevel moveInstruction = (MoveIfInsufficientSkillLevel) instruction;
        assertEquals(ComputerScience.class, moveInstruction.getHardSkillClass());
        assertEquals(4, moveInstruction.getSkillCap());
        assertEquals(-2, moveInstruction.getMoveCount());
    }
}
