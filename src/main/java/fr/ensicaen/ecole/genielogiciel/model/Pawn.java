package fr.ensicaen.ecole.genielogiciel.model;

public class Pawn {
    private static final int MOVE_PIXEL_X = 110;

    public int calculateMove(int numberOfTile) {
        return numberOfTile * MOVE_PIXEL_X;
    }
}
