package fr.ensicaen.ecole.genielogiciel.model.board.Action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Move implements Action {
    private static final int NUMBER_OF_MOVES_WHEN_YOU_DO_NOT_MOVE = 0;
    //TODO : Will become private
    public int _moveCount;

    public Move() {
        _moveCount = NUMBER_OF_MOVES_WHEN_YOU_DO_NOT_MOVE;
    }

    public Move(int n) {
        _moveCount = n;
    }

    @Override
    public void performAction(Player player) {
        player.advance(_moveCount);
    }
}
