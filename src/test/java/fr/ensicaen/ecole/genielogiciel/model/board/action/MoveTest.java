package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.Move;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.schooling.AST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    @Test
    public void test_perform_action() {
        String playerName = "ME";
        String schoolingName = "ast";
        Player player = new AST().createPlayer(playerName, schoolingName);
        int moveStep = 2;
        Move move = new Move(moveStep);
        move.performAction(player);
        System.out.println(player.getPosition());
        assertEquals(moveStep, player.getPosition());
    }
}