package fr.ensicaen.ecole.genielogiciel.model.board.action;

import org.junit.jupiter.api.Test;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import static org.mockito.Mockito.*;

public class UnionTest {

    @Test
    public void test_perform_action_with_actions() {
        Action action1 = mock(Action.class);
        Action action2 = mock(Action.class);
        Union union = new Union(action1, action2);
        Player player = mock(Player.class);

        union.performAction(player);

        verify(action1).performAction(player);
        verify(action2).performAction(player);
    }
}

