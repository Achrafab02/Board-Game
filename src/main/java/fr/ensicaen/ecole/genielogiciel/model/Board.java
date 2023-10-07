package fr.ensicaen.ecole.genielogiciel.model;

public class Board {
    private static final int NB_TILES = 6;

    public static int getNewPosition(int positionOfPlayer, int numberOfMoves) {
        int newPosition = positionOfPlayer + numberOfMoves;
        if (newPosition > NB_TILES) {
            newPosition = NB_TILES - (newPosition - NB_TILES);
        }
        return newPosition;
    }

    public static boolean isWinningPosition(int position) {
        if(position == NB_TILES) {
            return true;
        }
        return false;
    }
}
