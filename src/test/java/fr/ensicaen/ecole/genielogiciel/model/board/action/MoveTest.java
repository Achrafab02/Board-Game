package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.schooling.AST;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    @Test
    public void test_perform_action_zero_move() {
        Player player = new AST().createPlayer("", "");
        int moveStep = 0;
        Move move = new Move(moveStep);
        move.performAction(player);
        assertEquals(moveStep, player.getPosition());
    }

    @Test
    public void test_perform_action_positive_move() {
        Player player = new AST().createPlayer("", "");
        int moveStep = 2;
        Move move = new Move(moveStep);
        move.performAction(player);
        assertEquals(moveStep, player.getPosition());
    }

    @Test
    public void test_perform_action_negative_move_when_position_is_over_move_value() {
        Player player = new AST().createPlayer("", "");
        int positiveMoveStep = 3;
        Move positiveMove = new Move(positiveMoveStep);
        positiveMove.performAction(player);

        int moveStep = -2;
        Move move = new Move(moveStep);
        move.performAction(player);
        assertEquals(positiveMoveStep+moveStep, player.getPosition());
    }

    @Test
    public void test_perform_action_negative_move_when_position_is_under_move_value() {
        Player player = new AST().createPlayer("", "");

        int moveStep = -2;
        Move move = new Move(moveStep);
        move.performAction(player);
        assertEquals(0, player.getPosition());
    }
}