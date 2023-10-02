package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Pawn;
import fr.ensicaen.ecole.genielogiciel.model.Player;

public class PawnPresenter {
    private static final int MOVE_X = 110;

    private int _x = 0;
    private final Pawn _pawn;

    public PawnPresenter(Player player) {
        _pawn = new Pawn();
    }

    public void move(int numberOfTile) {
        _x += _pawn.calculateMove(numberOfTile);
    }
}
