package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.action.MoveToIndex;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TileRetakeExamTest {

    @Test
    public void test_fetch_instruction() {
        int positionIndex = 5;
        Point coordinates = new Point(2, 3);
        TileRetakeExam tile = new TileRetakeExam(positionIndex, coordinates);
        Player player = new Player();

        Action instruction = tile.fetchInstruction(player);

        assertTrue(instruction instanceof MoveToIndex);
        MoveToIndex moveAction = (MoveToIndex) instruction;
        assertEquals(0, moveAction.getIndexDestination());
    }
}

