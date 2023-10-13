package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;

public class BoardControllerPresenter {
    private final BoardPresenter _board;

    public BoardControllerPresenter() {
        _board = new BoardPresenter();
    }

    public Tile getTile(int tileIndex) {
        int lastTileIndex = getLastTileIndex();
        if (goalOverstepped(tileIndex, lastTileIndex)) {
            tileIndex = moveBackwards(tileIndex, lastTileIndex);
        }
        return _board.getTile(tileIndex);
    }

    private boolean goalOverstepped(int position, int lastTileIndex) {
        return (position >= lastTileIndex);
    }

    private int moveBackwards(int position, int lastTileIndex) {
        return (lastTileIndex - (position - lastTileIndex));
    }

    public int getLastTileIndex() {
        return BoardPresenter.getLastTileIndex();
    }
}
