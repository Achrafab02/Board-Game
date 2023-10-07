package fr.ensicaen.ecole.genielogiciel.model.board;

public class Action {
    private static final int NUMBER_OF_MOVES_WHEN_YOU_DO_NOT_MOVE = 0;
    public int _moveCount;

    public Action() {
        _moveCount = NUMBER_OF_MOVES_WHEN_YOU_DO_NOT_MOVE;
    }

    public Action(int n) {
        _moveCount = n;
    }
}
