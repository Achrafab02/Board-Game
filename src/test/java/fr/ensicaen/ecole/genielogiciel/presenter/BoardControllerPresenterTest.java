package fr.ensicaen.ecole.genielogiciel.presenter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardControllerPresenterTest {

    @Test
    public void test_goal_overstepped() {
        BoardControllerPresenter boardController = new BoardControllerPresenter();

        int position = 5;
        int lastTileIndex = 4;
        boolean overstepped = boardController.goalOverstepped(position, lastTileIndex);

        assertTrue(overstepped);
    }

    @Test
    public void test_move_backwards() {
        BoardControllerPresenter boardController = new BoardControllerPresenter();

        int position = 6;
        int lastTileIndex = 4;
        int newPosition = boardController.moveBackwards(position, lastTileIndex);

        assertEquals(2, newPosition);
    }
}
