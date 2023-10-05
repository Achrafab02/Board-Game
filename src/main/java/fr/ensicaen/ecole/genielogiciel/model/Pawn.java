package fr.ensicaen.ecole.genielogiciel.model;

public class Pawn {
    private static final int MOVE_X = 110; // FIXME nom pas explicite, je n'ai pas compris ce que c'est

    public int calculateMove(int numberOfTile) {
        return numberOfTile * MOVE_X;
    }
}
