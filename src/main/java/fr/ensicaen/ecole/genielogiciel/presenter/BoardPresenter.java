package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Point;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileMathClass;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileMathExam;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.TileNeutral;

public class BoardPresenter {
    private static final Tile[] HARD_CODED_BOARD = new Tile[]{
            new TileNeutral(0, new Point(365, 220)),
            new TileNeutral(1, new Point(290, 370)),
            new TileMathClass(2, new Point(315, 580)),
            new TileNeutral(3, new Point(480, 665)),
            new TileNeutral(4, new Point(680, 550)),
            new TileNeutral(5, new Point(730, 390)),
            new TileNeutral(6, new Point(810, 200)),
            new TileMathExam(7, new Point(1040, 170)),
            new TileNeutral(8, new Point(1190, 270)),
            new TileNeutral(9, new Point(1170, 520)),
            new TileNeutral(10, new Point(1040, 605))
    };
    private final Tile[] _tiles = HARD_CODED_BOARD;
    private final int LAST_TILES = 10;

    public Tile getTile(int tileIndex) {
        if (goalOverstepped(tileIndex)) {
            tileIndex = moveBackwards(tileIndex);
        }
        return _tiles[tileIndex];

    }

    private boolean goalOverstepped(int position) {
        return (position >= LAST_TILES);
    }

    private int moveBackwards(int position) {
        return (LAST_TILES - (position - LAST_TILES));
    }

    public int getWinningTileIndex() {
        return LAST_TILES;
    }
}
