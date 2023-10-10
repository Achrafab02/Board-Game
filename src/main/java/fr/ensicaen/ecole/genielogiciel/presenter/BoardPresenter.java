package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileMathClass;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileMathExam;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileNeutral;

public class BoardPresenter {
    private static final Tile[] HARD_CODED_BOARD = new fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile[]{new TileNeutral(), new TileNeutral(), new TileMathClass(), new TileNeutral(), new TileNeutral(), new TileNeutral(), new TileNeutral(), new TileMathExam(), new TileNeutral(), new TileNeutral(), new TileNeutral()};
    private final Tile[] _tiles = HARD_CODED_BOARD;
    private final int NB_TILES = 11;
    public Tile getActionFromTile(int tileIndex) {
        if (goalOverstepped(tileIndex)) {
            tileIndex = moveBackwards(tileIndex);
        }
        return _tiles[tileIndex];

    }


    private boolean goalOverstepped(int position) {
        return (position >= NB_TILES);
    }

    private int moveBackwards(int position) {
        return (NB_TILES - (position - NB_TILES));
    }
}
