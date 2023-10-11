package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;

public class BoardControllerPresenter {
    private BoardPresenter _board;

    public BoardControllerPresenter() {
        _board = new BoardPresenter();
    }

    public Tile getTile(int tileIndex) {
        return _board.getTile(tileIndex);
    }

    public int getWinningTileIndex() {
        return _board.getWinningTileIndex();
    }
}
