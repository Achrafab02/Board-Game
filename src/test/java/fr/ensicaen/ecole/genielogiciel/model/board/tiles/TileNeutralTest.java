package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.action.Move;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TileNeutralTest {

    @Test
    public void test_fetch_instruction() {
        int positionIndex = 5;
        Point coordinates = new Point(2, 3);
        TileNeutral tile = new TileNeutral(positionIndex, coordinates);
        Player player = new Player();

        Action instruction = tile.fetchInstruction(player);

        assertTrue(instruction instanceof Move);
    }
}
