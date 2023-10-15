package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexActionTest {
    @Test
    public void test_get_actions_with_empty_array() {
        ComplexAction complexAction = new ConcreteComplexAction();
        Action[] actions = complexAction.getActions();
        Action[] expected = new Action[0];
        assertArrayEquals(expected, actions);
    }

    @Test
    public void test_get_actions_with_non_empty_array() {
        Action action1 = new ConcreteAction();
        Action action2 = new ConcreteAction();
        ComplexAction complexAction = new ConcreteComplexAction(action1, action2);
        Action[] actions = complexAction.getActions();
        Action[] expected = { action1, action2 };
        assertArrayEquals(expected, actions);
    }

    private static class ConcreteComplexAction extends ComplexAction {
        public ConcreteComplexAction(Action... actions) {
            super(actions);
        }

        @Override
        public void performAction(Player player) {

        }
    }

    private static class ConcreteAction implements Action {
        @Override
        public void performAction(Player player) {

        }
    }
}

