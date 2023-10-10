package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.Board;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;

public class BoardControllerPresenter {
    private BoardPresenter _board;

    public BoardControllerPresenter() {
        _board = new BoardPresenter();
    }

    public Tile getActionFromTile(int tileIndex) {
        return _board.getActionFromTile(tileIndex);
    }
}
