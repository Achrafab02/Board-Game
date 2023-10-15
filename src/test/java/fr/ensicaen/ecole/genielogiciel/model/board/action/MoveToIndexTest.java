package fr.ensicaen.ecole.genielogiciel.model.board.action;


import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MoveToIndexTest {

    @Test
    public void test_perform_action() {
        int destinationIndex = 7;
        MoveToIndex moveAction = new MoveToIndex(destinationIndex);
        Player player = mock(Player.class);

        moveAction.performAction(player);

        verify(player).moveToIndex(destinationIndex);
    }
}
