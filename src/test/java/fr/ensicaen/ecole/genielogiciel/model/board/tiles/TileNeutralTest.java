package fr.ensicaen.ecole.genielogiciel.model.board.tiles;

import fr.ensicaen.ecole.genielogiciel.model.board.Action;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileNeutralTest {

    @Test
    void return_no_movement() {
        TileNeutral tileNeutral = new TileNeutral();
        Player player = new Player();
        Action action = tileNeutral.getMoveInstruction(player);
        assertEquals(0, action._moveCount);
    }
}