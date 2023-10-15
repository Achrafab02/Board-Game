package fr.ensicaen.ecole.genielogiciel.model.board.action;

import org.junit.jupiter.api.Test;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import static org.mockito.Mockito.*;

public class MoveTest {

    @Test
    public void test_perform_action() {
        int moveCount = 3;
        Move move = new Move(moveCount);
        Player player = mock(Player.class);

        move.performAction(player);

        verify(player).moveWithoutTileEffect(moveCount);
    }
}
