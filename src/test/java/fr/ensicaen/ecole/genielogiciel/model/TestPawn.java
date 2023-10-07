package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.board.Pawn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPawn {

    @Test
    public void test_move_pawn_without_starting_tile() {
        Pawn pawn = new Pawn();
        assertEquals(220, pawn.calculateMove(2));
    }
}