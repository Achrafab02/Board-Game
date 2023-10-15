package fr.ensicaen.ecole.genielogiciel.model.board.action;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class MoveToIndex implements Action {
    private final int _indexDestination;

    public MoveToIndex(int n) {
        _indexDestination = n;
    }

    @Override
    public void performAction(Player player) {
        player.moveToIndex(_indexDestination);
    }

    public int getIndexDestination() {
        return _indexDestination;
    }
}
