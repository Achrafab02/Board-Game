package fr.ensicaen.ecole.genielogiciel.model;

public class Action {
    private final int NUMBER_OF_MOVES_WHEN_YOU_DO_NOT_MOVE = 0;
    public int _moveCount;

    public Action() {
        _moveCount = NUMBER_OF_MOVES_WHEN_YOU_DO_NOT_MOVE;
    }

    public Action(int n) {
        _moveCount = n;
    }

    public int  getMoveCount (){
        return _moveCount;
    }
    public void  setMoveCount (int n){
        _moveCount = n;
    }
}
