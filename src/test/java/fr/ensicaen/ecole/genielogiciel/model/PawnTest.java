package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    @Test
    public void test_move_pawn_without_starting_tile() {
        Pawn pawn = new Pawn();
        int numberOfTile = 2;
        assertEquals(220, pawn.calculateMove(2));
    }
}